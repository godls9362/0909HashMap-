package DAO;
//DAO

import java.util.HashMap;

import DTO.wordDTO;



public class DAOword extends DAOBase {
	private HashMap<String, String> wList = new HashMap<String, String>();
	private DAOword() {
	}
	public static DAOword wmdao = null;

	public static DAOword getinstance() {
		if (wmdao == null) {
			wmdao = new DAOword();
		}
		return wmdao;
	}


	public void inputWord(String eng,String kor) {
		String sql = "insert into test values (?,?)";
		ppst = null;
		if (connect() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, eng);
				ppst.setString(2, kor);
				ppst.executeUpdate();
			} catch (Exception e) {
			} finally {
				disconnect();
			}
		}
	}

	public void deleteOne(String engW) {

		String sql = "delete from test where eng=?";
		ppst = null;
		if (connect() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, engW);
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				disconnect();
			}
		}
	}

	public HashMap<String, String> searchOne(String  engW) {
		String sql = "select * from test where eng=?";
		ppst = null;
		if (connect() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, engW);
				rs = ppst.executeQuery();
				while (rs.next()) {
					wList.put(rs.getString("eng"), rs.getString("kor"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return wList;
	}

	public HashMap<String, String> selectInc(String name) {
		String sql = "select * from test where eng like ?";
		ppst = null;
		rs = null;
		if (connect() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, "%" + name + "%");
				rs = ppst.executeQuery();
				while (rs.next()) {
					wList.put(rs.getString("eng"), rs.getString("kor"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return wList;
	}
	public HashMap<String, String> selectAll() {
		String sql = "select * from test";
		st = null;
		rs = null;
		if (connect() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					wList.put(rs.getString("eng"), rs.getString("kor"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				disconnect();
			}
		}
		return wList;
	}

	public void clearAll() {
		String sql = "delete from test";
		st = null;
		if (connect() != null) {
			try {
				st=conn.createStatement();
				st.executeQuery(sql);
			} catch (Exception e) {
			}finally {
				disconnect();
			}
		}
	}
	
	public void updateKor(String korW,String engW) {
	String sql="update test set kor=? where eng=?";
	ppst=null;
	if(connect()!=null) {
		try {
			ppst=conn.prepareStatement(sql);
			ppst.setString(1, korW);
			ppst.setString(2, engW);
			ppst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
	}
	}

}
