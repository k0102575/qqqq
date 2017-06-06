package lect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CroomDao {
	DBConnectionPool conPool;

	public CroomDao(DBConnectionPool conPool){
		this.conPool = conPool;
	} // 생성자

	public List<Croom> selectList() throws Exception {
		Connection con = conPool.getConnection();
		try (
				PreparedStatement stmt = con.prepareStatement("select crmno, name from croom order by crmno asc");
				) {
			ArrayList<Croom> list = new ArrayList<>();
			try(      ResultSet rs = stmt.executeQuery();) {
				Croom croom = null;

				while (rs.next()) {
					croom = new Croom();
					croom.setNo(rs.getInt("crmno"));
					croom.setName(rs.getString("name"));
					list.add(croom);
				} // while

			} // try
			return list;
		} finally {
			conPool.returnConnection(con);
		}

	} // selectList()
}
