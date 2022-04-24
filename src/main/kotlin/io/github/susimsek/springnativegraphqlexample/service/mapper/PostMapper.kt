package io.github.susimsek.springnativegraphqlexample.service.mapper



import io.github.susimsek.springnativegraphqlexample.domain.Post
import io.github.susimsek.springnativegraphqlexample.graphql.input.AddPostInput
import io.github.susimsek.springnativegraphqlexample.graphql.input.UpdatePostInput
import io.github.susimsek.springnativegraphqlexample.graphql.type.PostPayload
import org.mapstruct.*

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface PostMapper : EntityMapper<Post, PostPayload> {

    fun toEntity(input: AddPostInput): Post

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun partialUpdate(@MappingTarget entity: Post, input: UpdatePostInput)
}
