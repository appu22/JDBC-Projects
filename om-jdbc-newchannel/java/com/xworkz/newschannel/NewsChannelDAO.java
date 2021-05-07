package com.xworkz.newschannel;

import java.sql.SQLException;

public interface NewsChannelDAO {

	public void save(NewsChannelDTO dto) throws ClassNotFoundException, SQLException;

	public void updateByEditorByName(String editor, String name) throws ClassNotFoundException, SQLException;
	
	
	public void deleteByName(String name) throws ClassNotFoundException, SQLException;

}
