package com.jk.mapper.tree;

import com.jk.model.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TreeMapper {

    @Select("select * from layui_tree")
    List<Tree> queryTree();
}
