package com.mooc.meetingfilm.film.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeSingleFilmRespVO;
import com.mooc.meetingfilm.film.dao.entity.MoocFilmT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author whc
 * @since 2021-05-12
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {

    IPage<DescribeFilmRespVO> describeFilms(Page<DescribeFilmRespVO> page);

    DescribeSingleFilmRespVO describeFilmById(@Param("filmId") String flimId);  //问题：为什么这个地方需要引入@Param，而上面不需要
}
