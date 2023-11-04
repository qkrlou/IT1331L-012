package com.uap.it1311l.passwordencryptorapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import com.uap.it1311l.passwordencryptorapi.webclient.MyBatisEncryption;

@Service
public class EncryptDecryptService {
	@Autowired
	EncryptionApiClient apiClient;
	
	@Autowired
	MyBatisEncryption mybatisMapper;
	
	public EncryptionResponse encrypt(String password) {
		EncryptionResponse jgaj = apiClient.encrypt("keyhere", password, "AES");
		mybatisMapper.insert(jgaj.getResult());
		return jgaj;
	}
	
	public String decrypt(String hash) {
		if (mybatisMapper.exists(hash) > 0) {
			EncryptionResponse jgaj = apiClient.decrypt("keyhere", hash, "AES");
			return jgaj.getResult();
		} else {
			return "Encrypted Password does not exist.";
		}
	}
}
