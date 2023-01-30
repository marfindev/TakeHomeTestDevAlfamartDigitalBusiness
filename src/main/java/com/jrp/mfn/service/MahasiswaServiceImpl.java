package com.jrp.mfn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.mfn.model.Mahasiswa;
import com.jrp.mfn.repository.MahasiswaRepository;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {
	
	@Autowired
	private MahasiswaRepository mahasiswaRepository;
	
	@Override
	public List<Mahasiswa> getAllMahasiswa() {
		return mahasiswaRepository.findAll();
	}

	@Override
	public void saveMahasiswa(Mahasiswa mahasiswa) {
		this.mahasiswaRepository.save(mahasiswa);
		
	}

	@Override
	public Mahasiswa getMahasiswaById(long id) {
		Optional<Mahasiswa> optional = mahasiswaRepository.findById(id);
		Mahasiswa mahasiswa = null;
		if(optional.isPresent()) {
			mahasiswa = optional.get();
		}else {
			throw new RuntimeException("Mahasiswa not found for id :: " + id);
		}
		return mahasiswa;
	}

	@Override
	public void deleteMahasiswaById(long id) {
		this.mahasiswaRepository.deleteById(id);		
	}

}
