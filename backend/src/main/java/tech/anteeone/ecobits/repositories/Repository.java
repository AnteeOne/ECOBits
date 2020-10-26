package tech.anteeone.ecobits.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Repository {

    protected Connection con = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;


}
