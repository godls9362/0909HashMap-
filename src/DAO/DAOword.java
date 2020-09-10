package DAO;
//DAO

import java.util.ArrayList;
import java.util.HashMap;

import DTO.wordDTO;



public class DAOword extends DAOBase {
	private DAOword() {
	}
	public static DAOword wmdao = null;

	public static DAOword getinstance() {
		if (wmdao == null) {
			wmdao = new DAOword();
		}
		return wmdao;
	}


	public void inputWord(wordDTO dto) {
		String sql = "insert into test values (?,?)";
		ppst = null;
		if (connect() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, dto.getEng());
				ppst.setString(2, dto.getKor());
				ppst.executeUpdate();
			} catch (Exception e) {
			} finally {
				disconnect();
			}
		}
	}

	public void deleteOne(wordDTO eng) {

		String sql = "delete from test where eng=?";
		ppst = null;
		if (connect() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, eng.getEng());
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				disconnect();
			}
		}
	}

	public ArrayList<wordDTO> searchOne(wordDTO eng) {
		String sql = "select * from test where eng=?";
		ppst = null;
		ArrayList<wordDTO> wList=new ArrayList<>();
		if (connect() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, eng.getEng());
				rs = ppst.executeQuery();
				while (rs.next()) {
					wordDTO temp=new wordDTO();
					temp.setEng(rs.getString("eng"));
					temp.setKor(rs.getString("kor"));
					wList.add(temp);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return wList;
	}

	public ArrayList<wordDTO> selectInc(String word) {
		String sql = "select * from test where eng like ?";
		ArrayList<wordDTO> wList=new ArrayList<>();
		ppst = null;
		rs = null;
		if (connect() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, "%" + word + "%");
				rs = ppst.executeQuery();
				while (rs.next()) {
					wordDTO temp=new wordDTO();
					temp.setEng(rs.getString("eng"));
					temp.setKor(rs.getString("kor"));
					wList.add(temp);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return wList;
	}
	public ArrayList<wordDTO> selectAll() {
		ArrayList<wordDTO> wList=new ArrayList<>();
		String sql = "select * from test";
		st = null;
		rs = null;
		if (connect() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					wordDTO temp=new wordDTO();
					temp.setEng(rs.getString("eng"));
					temp.setKor(rs.getString("kor"));
					wList.add(temp);
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
	
	public void updateKor(wordDTO dto) {
	String sql="update test set kor=? where eng=?";
	ppst=null;
	if(connect()!=null) {
		try {
			ppst=conn.prepareStatement(sql);
			ppst.setString(1, dto.getKor());
			ppst.setString(2, dto.getEng());
			ppst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
	}
	}

}
