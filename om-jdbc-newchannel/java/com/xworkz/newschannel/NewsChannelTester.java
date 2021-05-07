package com.xworkz.newschannel;

import java.sql.SQLException;

public class NewsChannelTester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		NewsChannelDTO channelDTO = new NewsChannelDTO(1, "TV9", "Rehaman", "xyz", "kannada");
//		NewsChannelDTO channelDTO1 = new NewsChannelDTO(2, "NewsFirst", "S Ravikumar", "Ravi", "kannada");
//		NewsChannelDTO channelDTO2 = new NewsChannelDTO(3, "Public TV", "Ranganath", "Ranga", "kannada");

		NewsChannelDAO dao = new NewsChannelDAOImple();
//		dao.save(channelDTO);
//		dao.save(channelDTO1);
//		dao.save(channelDTO2);

//		dao.updateByEditorByName("Appu", "TV9");

		dao.deleteByName("NewsFirst");

	}

}
