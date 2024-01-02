package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer>{

	List<Mobile> findByMobileNameIgnoreCaseContaining(String name);

}
