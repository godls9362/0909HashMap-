package INF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import DAO.DAOword;
import DTO.wordDTO;
import ex01.wordManager;

public class wordINFImp implements wordINF {
	private DAOword wordDao = DAOword.getinstance();
	private wordDTO dto = new wordDTO();
	

	@Override
	public void input(String eng, String kor) {
		dto.setEng(eng);
		dto.setKor(kor);
		wordDao.inputWord(dto);
		

	}

	@Override
	public HashMap<String, String> output() {
		ArrayList<wordDTO> list = wordDao.selectAll();
		HashMap<String, String> wList = new HashMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			wList.put(list.get(i).getEng(), list.get(i).getKor());
		}
		Set<String> keys = wList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = wList.get(key);
			System.out.println("(���ܾ� :"+key +", �� :"+value+")");
		}
		return wList;
	}

	@Override
	public void remove(String eng) {
		System.out.println("�����Ͻ� ����ܾ �Է��ϼ���.");
		dto.setEng(eng);
		wordDao.deleteOne(dto);
		System.out.println("�����Ǿ����ϴ�.");
	}

	@Override
	public void modify(String mkor, String eng) {
		System.out.println("�����Ͻ� ����ܾ� ���� �Է����ּ���.");
		dto.setKor(mkor);
		System.out.println("���ܾ �Է����ּ���");
		dto.setEng(eng);
		wordDao.updateKor(dto);
		System.out.println("�����Ǿ����ϴ�.");
	}

	@Override
	public void clear() {
		wordDao.clearAll();
	}

}
