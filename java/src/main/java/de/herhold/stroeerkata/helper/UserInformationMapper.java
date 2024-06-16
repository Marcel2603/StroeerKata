package de.herhold.stroeerkata.helper;

import de.herhold.stroeerkata.api.model.UserInformation;
import de.herhold.stroeerkata.model.Post;
import de.herhold.stroeerkata.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserInformationMapper {
    UserInformationMapper INSTANCE = Mappers.getMapper(UserInformationMapper.class);

    UserInformation mapUserAndPost(User user, List<Post> posts);
}
