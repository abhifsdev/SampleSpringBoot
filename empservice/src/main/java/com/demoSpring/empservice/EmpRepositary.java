package com.demoSpring.empservice;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpRepositary extends JpaRepositoryImplementation<EmpEntity,Long> {
}
