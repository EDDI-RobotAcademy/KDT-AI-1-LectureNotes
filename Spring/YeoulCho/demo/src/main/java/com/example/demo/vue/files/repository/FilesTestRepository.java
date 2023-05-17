package com.example.demo.vue.files.repository;

import com.example.demo.vue.files.entity.FileTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesTestRepository extends JpaRepository<FileTest,Long> {

}
