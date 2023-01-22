package com.spring.batch.cvstodb.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.spring.batch.cvstodb.model.Person;
import com.spring.batch.cvstodb.processor.PersonItenProcessor;

@Configuration
@EnableBatchProcessing
public class Batchconfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private DataSource dataSource;

	private Resource outputResource = new FileSystemResource("output/outputData.csv");

	@Bean
	public JdbcCursorItemReader<Person> personItemreader(){
		JdbcCursorItemReader<Person> cursorItemReader = new JdbcCursorItemReader<>();
		cursorItemReader.setDataSource(dataSource);
		cursorItemReader.setSql("SELECT person_id,first_name,last_name,email,age FROM person");
		cursorItemReader.setRowMapper(new PersonRowMapper());
		return cursorItemReader;
	}

	@Bean
	public PersonItenProcessor processor(){
		return new PersonItenProcessor();
	}

	@Bean
	public FlatFileItemWriter<Person> writer(){
		FlatFileItemWriter<Person> writer = new FlatFileItemWriter<Person>();

		Person person;
		writer.setResource(outputResource);

		//String str=person.getEmail() + ", " + person.getFirstName() + "," + .person..person..person.

		DelimitedLineAggregator<Person> lineAggregator = new
				DelimitedLineAggregator<Person>();
		lineAggregator.setDelimiter(",");

		BeanWrapperFieldExtractor<Person>  fieldExtractor =
				new BeanWrapperFieldExtractor<Person>();
	fieldExtractor.setNames(new String[]{"personId","firstName","lastName","email","age"});

	lineAggregator.setFieldExtractor(fieldExtractor);
	//1,Ramu,Ramu,ramu@gmail.com,34

		writer.setLineAggregator(lineAggregator);

		  writer.setShouldDeleteIfExists(true);
		return writer;
	}

	@Bean
	public Step exportStep(){
		return stepBuilderFactory.get("exportStep").<Person,Person>chunk(100).
				reader(personItemreader()).processor(processor()).writer(writer()).build();
	}

	@Bean
	public Job exportPerosnJob(){
		return jobBuilderFactory.get("exportPeronJob").
				incrementer(new RunIdIncrementer()).flow(exportStep()).

				end().build();
	}
}
