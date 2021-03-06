package example

import graphql.schema.GraphQLNonNull
import io.ktor.server.application.*
import org.cufy.kaguya.*
import org.cufy.kaguya.ktor.context
import org.cufy.kaguya.ktor.graphql
import org.cufy.kaguya.ktor.schema

data class Entity(
    val name: String
)

val EntityObjectType = GraphQLObjectType<Entity> {
    name = "Entity"
    description = "Some entity."

    field(Entity::name) {
        type = GraphQLNonNull(GraphQLString)
        description = "The name of the entity."
    }

    field("nameWithCustomVar") {
        type = GraphQLNonNull(GraphQLString)
        description = "The name of the entity with the customVar in the context."

        resolver {
            it.name + graphQlContext.get("myCustomVar")
        }
    }
}

fun Application.configureGraphQL() {
    graphql {
        graphiql = true

        context {
            put("myCustomVar", Math.random())
        }

        schema {
            query {
                description = "The root query."

                field("getEntityWithName") {
                    type = EntityObjectType
                    description = "Get an entity instance."

                    val nameArg = argument<String> {
                        type = GraphQLString
                        name = "name"
                        description = "The name of the entity."
                    }

                    resolver {
                        Entity(nameArg())
                    }
                }
            }
        }
    }
}
