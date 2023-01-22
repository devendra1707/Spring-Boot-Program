package com.spring.batch.cvstodb.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.spring.batch.cvstodb.listener.JobCompletionNotificationListener;
import com.spring.batch.cvstodb.model.Person;
import com.spring.batch.cvstodb.processor.PersonItemProcessor;

@Configuration
@EnableBatchProcessing
public class Batchconfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;


	@Bean
	public FlatFileItemReader<Person> reader(){
		FlatFileItemReader<Person> reader=new FlatFileItemReader<Person>();
		reader.setResource(new ClassPathResource("person.csv"));
		reader.setLineMapper(new DefaultLineMapper<Person>()
				{{
					setLineTokenizer(new DelimitedLineTokenizer()
							{{
							setNames(new String[] { "firstName","lastName","email","age" });
							}});
							setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>()
									{{
										setTargetType(Person.class);
									}});
				}}
							);

	return reader;
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}


	@Bean
	public JdbcBatchItemWriter<Person> writer(){
		JdbcBatchItemWriter<Person> write=new JdbcBatchItemWriter<Person>();
		write.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
		write.setSql("INSERT INTO PERSON(FIRST_NAME,LAST_NAME,EMAIL,AGE)"
				+ " VALUES(:firstName,:lastName,:email,:age)");
		write.setDataSource(dataSource);
		return write;
	}


	@Bean
	public Step importCsvStep() {
		return stepBuilderFactory.get("importCsvStep")
				.<Person,Person> chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}


	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(importCsvStep())
				.end()
				.build();

	}


}
