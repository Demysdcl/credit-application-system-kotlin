package com.dclfactor.credit.application.system.modules.credit

import org.springframework.data.jpa.repository.JpaRepository

interface CreditRepository : JpaRepository<Credit, Long>