package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entity.Message;

public interface MessageDao {

//	crud principaux
	public Message insert(Message message);
	public void delete(Message message);
	public Message update(Message message);	
	public Message findById(Integer id);
	public List<Message> findAll();
	
//	autre fonction
	
	public Message envoyerMessage(Message message);
	public Message repondreMessage(Message message, Message messageReponse);
	public Message archiverMessage(Message message);
}
