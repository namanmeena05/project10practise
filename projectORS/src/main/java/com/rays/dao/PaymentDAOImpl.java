package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PaymentDTO;

@Repository
public class PaymentDAOImpl extends BaseDAOImpl<PaymentDTO> implements PaymentDAOInt {

	@PersistenceContext
	public EntityManager entityManager;

	List<Predicate> whereCondition = new ArrayList<Predicate>();

	@Override
	protected List<Predicate> getWhereClause(PaymentDTO dto, CriteriaBuilder builder, Root<PaymentDTO> qRoot) {

		return whereCondition;
	}

	@Override
	public Class<PaymentDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return PaymentDTO.class;
	}

	@Override
	public List search(PaymentDTO dto) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PaymentDTO> cq = builder.createQuery(PaymentDTO.class);
		Root<PaymentDTO> qRoot = cq.from(PaymentDTO.class);
		TypedQuery<PaymentDTO> tq = entityManager.createQuery(cq);
		List list = tq.getResultList();
		return list;
	}

}
