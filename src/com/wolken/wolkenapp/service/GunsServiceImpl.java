package com.wolken.wolkenapp.service;

import java.sql.SQLException;

import com.wolken.wolkenapp.dao.GunsDAO;
import com.wolken.wolkenapp.dao.GunsDAOImpl;
import com.wolken.wolkenapp.dto.GunsDTO;

public class GunsServiceImpl implements GunsService {
	GunsDAO gunsDAO=new GunsDAOImpl();
	@Override
	public void validateAdd(GunsDTO gunsDTO) {
		// TODO Auto-generated method stub
		if (gunsDTO.getGunsId()>0) {
			if(gunsDTO.getBrandName()!=null) {
				if(gunsDTO.getMadeIn()!=null) {
					if(gunsDTO.getName()!=null) {
						if(gunsDTO.getNoOfBullets()>0) {
							if(gunsDTO.getPrice()>0) {
								if(gunsDTO.getSerialNumber()>0) {
									if(gunsDTO.getType()!=null) {
										try {
											gunsDAO.add(gunsDTO);
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}else {
										System.out.println("wrong type");
									}
								}else {
									System.out.println("wrong serial number");
								}
							}else {
								System.out.println("wrong price");
							}
						}else {
							System.out.println("wrong no of bullets");
						}
					}else {
						System.out.println("wrong name");
					}
				}else {
					System.out.println("wrong made in");
				}
			}else {
				System.out.println("wrong brand name ");
			}
		}else {
			System.out.println("wrong id ");
		}
	}

	@Override
	public void validateGetAll() {
		// TODO Auto-generated method stub
		try {
			gunsDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void validateDeleteByGunsId(int gunsId) {
		// TODO Auto-generated method stub
		if(gunsId>0) {
			try {
				gunsDAO.deleteByGunsId(gunsId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("wrong id ");
		}
	}

	@Override
	public void validateUpdateBySerialNumber(int serialNumber) {
		// TODO Auto-generated method stub
		if(serialNumber>0) {
			try {
				gunsDAO.updateBySerialNumber(serialNumber);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("wrong serial Number");
		}
	}

	@Override
	public void validateGetAllBrandName(String brandName) {
		// TODO Auto-generated method stub
		if(brandName!=null) {
			try {
				gunsDAO.getAllBrandName(brandName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("wrong brand name");
		}
	}

	@Override
	public void validateGetAllByCountryName() {
		// TODO Auto-generated method stub
		try {
			gunsDAO.getAllByCountryName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
