package io.github.susimsek.springnativegraphqlexample.graphql.hint

import graphql.GraphQL
import graphql.analysis.QueryVisitorFieldArgumentEnvironment
import graphql.analysis.QueryVisitorFieldArgumentInputValue
import graphql.execution.Execution
import graphql.execution.nextgen.result.RootExecutionResultNode
import graphql.language.*
import graphql.parser.ParserOptions
import graphql.schema.*
import graphql.schema.validation.SchemaValidationErrorCollector
import graphql.util.NodeAdapter
import graphql.util.NodeZipper
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.core.NativeDetector
import org.springframework.core.io.ClassPathResource
import org.springframework.graphql.boot.GraphQlSourceBuilderCustomizer
import org.springframework.graphql.data.GraphQlRepository
import org.springframework.graphql.execution.GraphQlSource
import org.springframework.nativex.hint.ResourceHint
import org.springframework.nativex.hint.TypeAccess
import org.springframework.nativex.hint.TypeHint
import org.springframework.nativex.type.NativeConfiguration

@TypeHint(
    types = [
        GraphQlRepository::class],
    access = [TypeAccess.QUERY_PUBLIC_METHODS])

@TypeHint(
    typeNames = ["graphql.analysis.QueryTraversalContext", "graphql.schema.idl.SchemaParseOrder"],
    types = [Argument::class, ArrayValue::class, Boolean::class, BooleanValue::class, DataFetchingEnvironment::class, Directive::class, DirectiveDefinition::class, DirectiveLocation::class, Document::class, EnumTypeDefinition::class, EnumTypeExtensionDefinition::class, EnumValue::class, EnumValueDefinition::class, Execution::class, Field::class, FieldDefinition::class, FloatValue::class, FragmentDefinition::class, FragmentSpread::class, GraphQL::class, GraphQLArgument::class, GraphQLCodeRegistry.Builder::class, GraphQLDirective::class, GraphQLEnumType::class, GraphQLEnumValueDefinition::class, GraphQLFieldDefinition::class, GraphQLInputObjectField::class, GraphQLInputObjectType::class, GraphQLInterfaceType::class, GraphQLList::class, GraphQLNamedType::class, GraphQLNonNull::class, GraphQLObjectType::class, GraphQLOutputType::class, GraphQLScalarType::class, GraphQLSchema::class, GraphQLSchemaElement::class, GraphQLUnionType::class, ImplementingTypeDefinition::class, InlineFragment::class, InputObjectTypeDefinition::class, InputObjectTypeExtensionDefinition::class, InputValueDefinition::class, IntValue::class, InterfaceTypeDefinition::class, InterfaceTypeExtensionDefinition::class, MutableList::class, ListType::class, NodeAdapter::class, NodeZipper::class, NonNullType::class, NullValue::class, ObjectField::class, ObjectTypeDefinition::class, ObjectTypeExtensionDefinition::class, ObjectValue::class, OperationDefinition::class, OperationTypeDefinition::class, ParserOptions::class, QueryVisitorFieldArgumentEnvironment::class, QueryVisitorFieldArgumentInputValue::class, RootExecutionResultNode::class, ScalarTypeDefinition::class, ScalarTypeExtensionDefinition::class, SchemaDefinition::class, SchemaExtensionDefinition::class, SchemaValidationErrorCollector::class, SelectionSet::class, StringValue::class, TypeDefinition::class, TypeName::class, UnionTypeDefinition::class, UnionTypeExtensionDefinition::class, VariableDefinition::class, VariableReference::class],
    access = [TypeAccess.PUBLIC_CLASSES, TypeAccess.PUBLIC_CONSTRUCTORS, TypeAccess.PUBLIC_FIELDS, TypeAccess.PUBLIC_METHODS, TypeAccess.DECLARED_CLASSES, TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.DECLARED_FIELDS, TypeAccess.DECLARED_METHODS]
)
@ResourceHint(patterns = ["graphiql/index.html", GraphQlNativeHints.GRAPHQL_SCHEMA_CONFIG_PROPERTIES])
@Lazy(false)
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(name = ["org.springframework.nativex.NativeListener"])
class GraphQlNativeHints : NativeConfiguration {
    @Bean
    fun graphQlSourceBuilderCustomizer(): GraphQlSourceBuilderCustomizer {
        return GraphQlSourceBuilderCustomizer { builder: GraphQlSource.Builder ->
            if (NativeDetector.inNativeImage()) {
                builder.schemaResources(ClassPathResource(GRAPHQL_SCHEMA_CONFIG_PROPERTIES))
            }
        }
    }

    companion object {
        const val GRAPHQL_SCHEMA_CONFIG_PROPERTIES = "graphql/schema.graphqls"
    }
}