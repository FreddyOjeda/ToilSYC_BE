package com.kpjunaid.mapper;

import com.kpjunaid.dto.UpdateUserInfoDto;
import com.kpjunaid.entity.User;
import com.kpjunaid.entity.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-06T20:21:45-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public User userUpdateDtoToUser(UpdateUserInfoDto updateUserInfoDto) {
        if ( updateUserInfoDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        if ( updateUserInfoDto.getFirstName() != null ) {
            user.firstName( updateUserInfoDto.getFirstName() );
        }
        if ( updateUserInfoDto.getLastName() != null ) {
            user.lastName( updateUserInfoDto.getLastName() );
        }
        if ( updateUserInfoDto.getIntro() != null ) {
            user.intro( updateUserInfoDto.getIntro() );
        }
        if ( updateUserInfoDto.getGender() != null ) {
            user.gender( updateUserInfoDto.getGender() );
        }
        if ( updateUserInfoDto.getHometown() != null ) {
            user.hometown( updateUserInfoDto.getHometown() );
        }
        if ( updateUserInfoDto.getCurrentCity() != null ) {
            user.currentCity( updateUserInfoDto.getCurrentCity() );
        }
        if ( updateUserInfoDto.getEduInstitution() != null ) {
            user.eduInstitution( updateUserInfoDto.getEduInstitution() );
        }
        if ( updateUserInfoDto.getWorkplace() != null ) {
            user.workplace( updateUserInfoDto.getWorkplace() );
        }
        if ( updateUserInfoDto.getBirthDate() != null ) {
            user.birthDate( updateUserInfoDto.getBirthDate() );
        }

        return user.build();
    }
}
