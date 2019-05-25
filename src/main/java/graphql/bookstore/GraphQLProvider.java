package graphql.bookstore;

import graphql.GraphQL;
import graphql.bookstore.controller.BookController;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GraphQLProvider {

    @Autowired
    private BookController bookController;

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() { 
        return graphQL;
    }

    @PostConstruct
    public void init() {
        GraphQLSchema graphQLSchema = buildSchema();
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema() {
        return new GraphQLSchemaGenerator()
                .withBasePackages("io.leangen") //not mandatory but strongly recommended to set your "root" packages
                .withOperationsFromSingleton(bookController) //register the service
                .generate();
    }
}
