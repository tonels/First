package com.aust.two.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Version;

import com.aust.two.value.BookValue;
import lombok.Data;

@SqlResultSetMappings({
    @SqlResultSetMapping(
            name = "BookAuthorMapping",
            entities = {
                @EntityResult(
                        entityClass = Book.class,
                        fields = {
                            @FieldResult(name = "id", column = "id"),
                            @FieldResult(name = "title", column = "title"),
                            @FieldResult(name = "author", column = "author_id"),
                            @FieldResult(name = "version", column = "version")}),
                @EntityResult(
                        entityClass = Author.class,
                        fields = {
                            @FieldResult(name = "id", column = "authorId"),
                            @FieldResult(name = "firstName", column = "firstName"),
                            @FieldResult(name = "lastName", column = "lastName"),
                            @FieldResult(name = "version", column = "authorVersion")})}),
    @SqlResultSetMapping(
            name = "AuthorMapping",
            entities = @EntityResult(
                    entityClass = Author.class,
                    fields = {
                        @FieldResult(name = "id", column = "authorId"),
                        @FieldResult(name = "firstName", column = "firstName"),
                        @FieldResult(name = "lastName", column = "lastName"),
                        @FieldResult(name = "version", column = "version")})),
    @SqlResultSetMapping(
            name = "AuthorBookCountMapping",
            entities = @EntityResult(
                    entityClass = Author.class,
                    fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "firstName", column = "firstName"),
                        @FieldResult(name = "lastName", column = "lastName"),
                        @FieldResult(name = "version", column = "version")}),
            columns = @ColumnResult(name = "bookCount", type = Long.class)),
    @SqlResultSetMapping(
            name = "BookValueMapping",
            classes = @ConstructorResult(
                    targetClass = BookValue.class,
                    columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "title"),
                        @ColumnResult(name = "version", type = Long.class),
                        @ColumnResult(name = "authorName")})),
    @SqlResultSetMapping(
            name = "BookValueAndEntityMapping",
            entities = {
                @EntityResult(
                        entityClass = Book.class,
                        fields = {
                            @FieldResult(name = "id", column = "id"),
                            @FieldResult(name = "title", column = "title"),
                            @FieldResult(name = "author", column = "author_id"),
                            @FieldResult(name = "version", column = "version")})},
            classes = @ConstructorResult(
                    targetClass = BookValue.class,
                    columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "title"),
                        @ColumnResult(name = "version", type = Long.class),
                        @ColumnResult(name = "authorName")}))
})
@Entity
@Data
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
	
    @Version
    @Column(name = "version")
    private int version;

    @Column
    private String firstName;

    @Column
    private String lastName;

}
