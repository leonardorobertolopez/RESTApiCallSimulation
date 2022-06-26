package com.securid.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.securid.entities.response.Initialize.Context;
import com.securid.entities.response.Initialize.MyPojo;
import com.securid.entities.status.MyPojoStatus;

public class AuthenticationImplementacion implements DAO<MyPojo, String>, ConexionSQLDB {

	private PreparedStatement psBuscar;
	private PreparedStatement psInsertar;
	private PreparedStatement psEliminar;
	private PreparedStatement psActualizar;
	private PreparedStatement psListar;
	private final String KEY = "JavaWebAPI";
	
	private Boolean actualizar(MyPojo mypojo) {
		String query = "update usuarios set clave = AES_ENCRYPT(?, ?) where correo = ?";
		try {
			if (null == psActualizar) {
				psActualizar = getConexion().prepareStatement(query);

			}
//			psActualizar.setString(1, usuario.getClave());
//			psActualizar.setString(2, KEY);
//			psActualizar.setString(3, usuario.getCorreo());

			return psActualizar.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public Boolean eliminar(MyPojo mypojo) {
		String query = "delete from javawebapi55961.authentication where authnAttemptId = ?";
		try {
			if (null == psEliminar) {
				psEliminar = getConexion().prepareStatement(query);
			}

			psEliminar.setString(1, mypojo.getContext().getAuthnAttemptId());

			return psEliminar.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Boolean guardar(MyPojo mypojo) {
		MyPojo aux = buscar(mypojo.getContext().getAuthnAttemptId());
		if (null == aux) {
			return insertar(mypojo);
		} else {
			return actualizar(mypojo);
		}

	}
	
	
	public Boolean insertar(MyPojo mypojo) {
		
		String query = "insert into javawebapi55961.authentication set authnAttemptId = ?";
		try {
			if (null == psInsertar) {
				psInsertar = getConexion().prepareStatement(query);
			}
			psInsertar = getConexion().prepareStatement(query);
			psInsertar.setString(1, mypojo.getContext().getAuthnAttemptId());

			return psInsertar.executeUpdate() == 1; // when returns 1 insert the object correctly

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public List<MyPojo> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public MyPojo buscar(String authnAttemptId) {
		MyPojo mypojo = null;
		String query = "select * from javawebapi55961.authentication where authnAttemptId = ?";

		try {
			// chequeamos si esta en null para evitar que lo instancie cada vez que consulte
			if (null == psBuscar) {
				psBuscar = getConexion().prepareStatement(query);
			}
			psBuscar.setString(1, authnAttemptId);

			ResultSet rs = psBuscar.executeQuery();

			if (rs.next()) {
				mypojo = new MyPojo();
                mypojo.setContext(new Context("", authnAttemptId, ""));
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mypojo;
	}
	
	
	public MyPojoStatus buscarStatus(String authnAttemptId) {
		MyPojoStatus mypojo = null;
		String query = "select * from javawebapi55961.authentication where authnAttemptId = ?";

		try {
			// chequeamos si esta en null para evitar que lo instancie cada vez que consulte
			if (null == psBuscar) {
				psBuscar = getConexion().prepareStatement(query);
			}
			psBuscar.setString(1, authnAttemptId);

			ResultSet rs = psBuscar.executeQuery();

			if (rs.next()) {
				//Does not charge the authnAttemptId because is not responded. only check it existence
				mypojo = new MyPojoStatus();
               
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mypojo;
	}
	
}
