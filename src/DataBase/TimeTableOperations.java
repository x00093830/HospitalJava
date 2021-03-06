package DataBase;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

/**
 * Created by Roland on 08/03/2015.
 */
public class TimeTableOperations {
    private Connection conn;
    private ResultSet rset;
    private PreparedStatement pstmt;
    private Statement stmt;

    public TimeTableOperations(){
    conn = openDB();
    }

    // This method opens a connection to the Oracle database
    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();

//			// Tallaght
//			ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
//            String uName = "X00115013";
//            ods.setUser(uName);
//            String uPass = "db02Dec77";
//            ods.setPassword(uPass);

//			Home Oracle XE
            ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521/XE");
            String uName = "SYSTEM";
            ods.setUser(uName);
            String uPass = "30905149";
            ods.setPassword(uPass);

            conn = ods.getConnection();
            System.out.println("TimeTables connected.");
        } catch (Exception e) {
            System.out.print("Unable to load driver " + e);
            System.exit(1);
        }
        return conn;
    }

    // This method closes the connection to the Oracle database
    public void closeDB() {
        try {
            conn.close();
            System.out.print("Connection closed");
        } catch (SQLException e) {
            System.out.print("Could not close connection ");
            e.printStackTrace();
        }
    }



    public ResultSet getConsultantTT() {
        try {
            String queryString = "SELECT * FROM consultantTimeTable ORDER BY time";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getXRayTT() {
        try {
            String queryString = "SELECT * FROM XRayTimeTable ORDER BY time";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getCTScanTT() {
        try {
            String queryString = "SELECT * FROM CTScanTimeTable ORDER BY time";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getMRIScanTT() {
        try {
            String queryString = "SELECT * FROM MRITimeTable ORDER BY time";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }


    public void setXRayTimeTable(int timeIn, String taken, int consultantNumIn ){
        try {
            String queryString1 = "INSERT INTO XRayTimeTable(xRay_ID, time, taken,con_Name)VALUES(xRay_seq.nextval,?,?,?)";
            pstmt = conn.prepareStatement(queryString1);
            pstmt.setInt(1,timeIn-1);
            pstmt.setString(2, "taken");
            pstmt.setString(3,getConsultantName(consultantNumIn));
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void setMRITimeTable(int timeIn, String taken,int consultantNumIn ){
        try {
            String queryString1 = "INSERT INTO MRITimeTable(mRI_ID, time,taken, con_Name)VALUES(mRI_seq.nextval,?,?,?)";
            pstmt = conn.prepareStatement(queryString1);
            pstmt.setInt(1,timeIn);
            pstmt.setString(2,taken);
            pstmt.setString(3, getConsultantName(consultantNumIn));
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void setCTTimeTable(int timeIn, String taken, int consultantNumber ) {
        try {
            String queryString1 = "INSERT INTO CTScanTimeTable(cT_ID, time,taken, con_Name)VALUES(cT_seq.nextval,?,?,?)";
            pstmt = conn.prepareStatement(queryString1);
            pstmt.setInt(1, timeIn);
            pstmt.setString(2, taken);
            pstmt.setString(3, getConsultantName(consultantNumber));
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void setConsultantTimeTable(int timeIn, String consultantNumIn ){
        try {
            String queryString1 = "INSERT INTO ConsultantTimeTable(conTT_ID,time,con_Name)VALUES(conTT_seq.nextval,?,?)";
            pstmt = conn.prepareStatement(queryString1);
            pstmt.setInt(1,timeIn);
            pstmt.setString(2, consultantNumIn);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public ResultSet getConsultant(){
        try {
            String queryString = "SELECT * FROM Consultant";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }

    public String getConsultantName(int iDIn){
        String temp="";
        try {
            String queryString = "SELECT * FROM Consultant WHERE con_ID = "+iDIn;
            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
            while (rset.next()){
                temp=rset.getString(2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;
    }


    public void setXRayFree(String taken){
        try {
            String queryString1 = "INSERT INTO XRayTimeTable(xRay_ID,taken)VALUES(xRay_seq.nextval,?)";
            pstmt = conn.prepareStatement(queryString1);
            pstmt.setString(1,taken);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void setMRIFree(String taken){
        try {
            String queryString1 = "INSERT INTO MRITimeTable(mRI_ID,taken)VALUES(mRI_seq.nextval,?)";
            pstmt = conn.prepareStatement(queryString1);
            pstmt.setString(1,taken);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void setCTFree(String taken){
        try {
            String queryString1 = "INSERT INTO CTScanTimeTable(cT_ID,taken)VALUES(cT_seq.nextval,?)";
            pstmt = conn.prepareStatement(queryString1);
            pstmt.setString(1,taken);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
