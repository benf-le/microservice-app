package com.benfle.borrowingservice.command.api.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrowing, String>{

}