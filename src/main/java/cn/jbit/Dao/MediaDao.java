package cn.jbit.Dao;

import java.util.List;

import cn.jbit.entity.Media;

public interface MediaDao {
	
	public Media addMedia(Media media);
	
	public Integer update(Media media);
	
	public Media findById(Long mediaId);
	

	public List<Media> findAll(Integer pageNo, Integer pagesize);
	
	public List<Media> findAlla();
	
	public Long count();
	

}
