package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.SequenceKodeDao;
import service.SequenceKodeService;

@Transactional
@Service
public class SequenceKodeService {
	private SequenceKodeDao sequenceDao = new SequenceKodeDao();

	public String CustomerSequence() throws Exception {
		String kodeBaru = "";
		int lastCode = this.sequenceDao.CustomerSequence();
		
		if (lastCode < 10){
			kodeBaru = "C000"+lastCode;
		} else if(lastCode > 10 && lastCode < 100){
			kodeBaru="C00"+lastCode;
		} else if(lastCode > 100 && lastCode < 1000){
			kodeBaru="C0"+lastCode;
		} else if(lastCode > 1000 && lastCode < 9999){
			kodeBaru="C"+lastCode;
		}
		return kodeBaru;
	}

}
