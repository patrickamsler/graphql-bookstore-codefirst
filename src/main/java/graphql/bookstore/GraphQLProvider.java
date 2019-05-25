package graphql.bookstore;

import graphql.GraphQL;
import graphql.bookstore.controller.AuthorController;
import graphql.bookstore.controller.BookController;
import graphql.bookstore.controller.OrderController;
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
    @Autowired
    private OrderController orderController;
    @Autowired
    private AuthorController authorController;

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
                .withBasePackages("graphql.bookstore") //not mandatory but strongly recommended to set your "root" packages
                .withOperationsFromSingleton(bookController) //register the service
                .withOperationsFromSingleton(orderController)
                .withOperationsFromSingleton(authorController)
                .generate();
    }
}
