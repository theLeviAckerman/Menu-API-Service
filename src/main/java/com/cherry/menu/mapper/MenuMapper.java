package com.cherry.menu.mapper;

import com.cherry.menu.dto.MenuDto;
import com.cherry.menu.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper {

    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    Menu mapMenuDtoToMenu(MenuDto menuDto);
    MenuDto mapMenuToMenuDto(Menu menu);
}
