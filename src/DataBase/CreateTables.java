package DataBase;

/**
 * Created by David on 25/02/2015.
 */

import java.sql.*;
import java.util.*;
import oracle.jdbc.pool.OracleDataSource;

public class CreateTables {
    private Connection conn;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rset;

    // Opening Database
    public Connection openDB() {
        String url;
        Scanner in = new Scanner(System.in);
        try {
            // Load the Oracle JDBC driver
            OracleDataSource ods = new OracleDataSource();
            System.out.println("Type global1 or home");
            String val = in.next();

            // Tallaght College
            if (val.equalsIgnoreCase("global1")) {
                ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
                ods.setUser("X00115013");
                ods.setPassword("db02Dec77");
                conn = ods.getConnection();
                System.out.println("connected.");
            }
            // At Home
            else if (val.equalsIgnoreCase("home")) {
                ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521/XE");
                ods.setUser("system");
                ods.setPassword("30905149");
                conn = ods.getConnection();
                System.out.println("connected.");
            }

        } catch (Exception e) {
            System.out.println("Unable to load driver. " + e);
        }
        return conn;
    }

    // Dropping tables and sequences. Dropped in the reverse order than the createTable method
    public void dropTables() {
        System.out.println("Checking for existing tables & Sequences");

        try {
            // Get a Statement object
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE PatientChart");
                System.out.println("PatientChart Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // PATIENTCHART END
            try {
                stmt.execute("DROP TABLE Prescription");
                System.out.println("Prescription Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // PRESCRIPTION END
            try {
                stmt.execute("DROP TABLE Payment");
                System.out.println("Payment Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // PAYMENT END
            try {
                stmt.execute("DROP TABLE Timetable");
                System.out.println("Timetable Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // TIME TABLE END
            // REFERRAL Sequence & Table START
            try{
                stmt.execute("DROP SEQUENCE GPID");
                System.out.println("Referral Sequence dropped.");
            }catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try{
                stmt.execute("DROP TABLE Referral");
                System.out.println("Referral Table dropped");
            }catch (SQLException ex){
                // The table doesn't exist
            }   // REFERRAL END
            // CONSULTANT Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE xRay_seq");
                System.out.println("xRayTT Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE XRayTimeTable");
                System.out.println("xRayTT Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            }
            // CONSULTANT Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE mRI_seq");
                System.out.println("MRI Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE MRITimeTable");
                System.out.println("MRI Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            }
            // CONSULTANT Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE cT_seq");
                System.out.println("cT_seq Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE CTScanTimeTable");
                System.out.println("CT Scan Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            }
            // CONSULTANT Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE conTT_seq");
                System.out.println("conTT_seq Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE consultantTimetable");
                System.out.println("ConsultantTT Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            }


            // APPOINTMENT Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE APPID");
                System.out.println("Appointment Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE Appointment");
                System.out.println("Appointment Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // APPOINTMENT END

            // ADMIN Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE StaffID");
                System.out.println("Administration Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE Administration");
                System.out.println("Administration Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            }   // ADMIN END




            // CONSULTANT Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE ConID");
                System.out.println("Consultant Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE Consultant");
                System.out.println("Consultant Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // CONSULTANT END

            // PATIENT Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE PatientID");
                System.out.println("Patient Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE Patient");
                System.out.println("Patient Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // PATIENT END

            // MEDICINE & Table START
            try {
                stmt.execute("DROP SEQUENCE MedID");
                System.out.println("Medicine Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE Medicine");
                System.out.println("Medicine Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // MEDICINE END

            // CARD DETAILS & Table START
            try {
                stmt.execute("DROP SEQUENCE CardID");
                System.out.println("Card Details Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE CardDetails");
                System.out.println("CardDetails Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // CARD DETAILS END

            // MEDICAL CARD Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE GMSID");
                System.out.println("Medical Card Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE MedicalCard");
                System.out.println("MedicalCard Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // MEDICAL CARD END

            // HEALTH INSURANCE Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE PolicyID");
                System.out.println("Health Insurance Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE HealthInsurance");
                System.out.println("HealthInsurance Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // HEALTH INSURANCE END

            // BED Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE BedID");
                System.out.println("Bed Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE Bed");
                System.out.println("Bed Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // BED END

            // MEDICAL EQUIPMENT Sequence & Table START
            try {
                stmt.execute("DROP SEQUENCE EquipID");
                System.out.println("Medical Equipment Sequence dropped.");
            } catch (SQLException ex) {
                // If in here then the Sequence did not exist
            }
            try {
                stmt.execute("DROP TABLE MedicalEquipment");
                System.out.println("MedicalEquipment Table dropped");
            } catch (SQLException ex) {
                // The table doesn't exist
            } // MEDICAL EQUIPMENT END

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void CreateTable() {
        try {
            //ADMIN START creating table
            System.out.println("Creating Administration");
            String createAdmin = "CREATE TABLE Administration (staff_ID NUMBER PRIMARY KEY, password VARCHAR2(255))";
            pstmt = conn.prepareStatement(createAdmin);
            pstmt.executeUpdate(createAdmin);
            // creating Sequence
            String createAdminSeq = " CREATE SEQUENCE StaffID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createAdminSeq);
            pstmt.executeUpdate(createAdminSeq);

           /* // Insert data into table
            String insertAdmin = "INSERT INTO Administration (staff_ID, password) Values(StaffID.nextVal,?)";
            pstmt = conn.prepareStatement(insertAdmin);
            pstmt.setString(1, "password");
            pstmt.executeUpdate();
*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        } // END ADMIN
        try {
            //CONSULTANT START creating table
            System.out.println("Creating Consultant");
            String createCon = "CREATE TABLE Consultant (con_ID NUMBER PRIMARY KEY, con_Name VARCHAR2(255), speciality VARCHAR2(50))";
            pstmt = conn.prepareStatement(createCon);
            pstmt.executeUpdate(createCon);
            // creating Sequence
            String createConSeq = " CREATE SEQUENCE ConID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createConSeq);
            pstmt.executeUpdate(createConSeq);
            // Insert data into table
            String insertCon = "INSERT INTO Consultant (con_ID,con_Name,speciality) Values(ConID.nextVal,?,?)";
            pstmt = conn.prepareStatement(insertCon);
            pstmt.setString(1, "Dr John Doe ");
            pstmt.setString(2, "Pediatrics");
            System.out.println("Consultant inserted");
            pstmt.executeUpdate();
            pstmt = conn.prepareStatement(insertCon);
            pstmt.setString(1, "Dr Jane Doe ");
            pstmt.setString(2, "Radiology");
            System.out.println("Consultant inserted");
            pstmt.executeUpdate();
            pstmt = conn.prepareStatement(insertCon);
            pstmt.setString(1, "Dr Jack Smith ");
            pstmt.setString(2, "Neurology");
            System.out.println("Consultant inserted");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
        try {
            //Patient START creating table
            System.out.println("Creating Patient");
            String createPatient = "CREATE TABLE Patient (patient_Number NUMBER PRIMARY KEY, patientFName VARCHAR2(30), patientLName VARCHAR2(30)," +
                    "PatientDOB DATE,PatientGender VARCHAR2(10), BloodType VARCHAR2(5),Symptoms VARCHAR2(255), Diagnoses VARCHAR2(255), RequiredTreatment " +
                    "VARCHAR2(255),EquipmentNeeded NUMBER, EquipmentUsed NUMBER,Allergies VARCHAR2(255),PrescriptionUsed VARCHAR2(255),PatientEmail VARCHAR2(30),PatientPhone VARCHAR2(15))";
            pstmt = conn.prepareStatement(createPatient);
            pstmt.executeUpdate(createPatient);
            // creating Sequence
            String createPatientSeq = " CREATE SEQUENCE PatientID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createPatientSeq);
            pstmt.executeUpdate(createPatientSeq);
            // Insert data into table
           /* String insertCon = "INSERT INTO Consultant (con_ID,con_Name,department,speciality, password) Values(PatientID.nextVal,?,?,?,?)";
            pstmt = conn.prepareStatement(insertCon);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Peds");
            pstmt.setString(3, "feet");
            pstmt.setString(4, "Password");
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception Patient" + e);
            System.exit(1);
        }
        try {
            //MEDICINE START creating table
            System.out.println("Creating Medicine");
            String createMedicine = "CREATE TABLE Medicine (Med_ID NUMBER PRIMARY KEY, Med_Name VARCHAR2(50)" +
                    ",Dosage NUMBER, StockLevel NUMBER)";
            pstmt = conn.prepareStatement(createMedicine);
            pstmt.executeUpdate(createMedicine);
            // creating Sequence
            String createMedSeq = " CREATE SEQUENCE MedID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createMedSeq);
            pstmt.executeUpdate(createMedSeq);
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception Meds " + e);
            System.exit(1);
        }
        try {
            //CARD DETAILS START creating table
            System.out.println("Creating Card Details");
            String createCardDetails = "CREATE TABLE CardDetails (Card_ID NUMBER PRIMARY KEY, cardType VARCHAR2(30)" +
                    ",SecurityCode NUMBER,CardHolder VARCHAR2(70),ExpiryDate DATE)";
            pstmt = conn.prepareStatement(createCardDetails);
            pstmt.executeUpdate(createCardDetails);
            // creating Sequence
            String createCardSeq = " CREATE SEQUENCE CardID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createCardSeq);
            pstmt.executeUpdate(createCardSeq);
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
        try {
            //MEDICAL CARD  START creating table
            System.out.println("Creating Medical Card");
            String createMCardDetails = "CREATE TABLE MedicalCard (GMSNumber NUMBER PRIMARY KEY, PPSN NUMBER, Gender VARCHAR2(20)" +
                    ",DOB DATE,ValidTo DATE,HolderName VARCHAR2(70))";
            pstmt = conn.prepareStatement(createMCardDetails);
            pstmt.executeUpdate(createMCardDetails);
            // creating Sequence
            String createMCardSeq = " CREATE SEQUENCE GMSID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createMCardSeq);
            pstmt.executeUpdate(createMCardSeq);
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
        try {
            //HEALTH INSURANCE  START creating table
            System.out.println("Creating Health Insurance");
            String createInsurDetails = "CREATE TABLE HealthInsurance (Policy_number NUMBER PRIMARY KEY, Company_name VARCHAR2(255)" +
                    ",Coverage_type NUMBER,Expiry_date DATE)";
            pstmt = conn.prepareStatement(createInsurDetails);
            pstmt.executeUpdate(createInsurDetails);
            // creating Sequence
            String createInsurSeq = " CREATE SEQUENCE PolicyID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createInsurSeq);
            pstmt.executeUpdate(createInsurSeq);
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
        try {
            //BED  START creating table
            System.out.println("Creating Bed");
            String createBedDetails = "CREATE TABLE Bed (Bed_ID NUMBER PRIMARY KEY , CurrentBeds NUMBER, MaxBed NUMBER)";
            pstmt = conn.prepareStatement(createBedDetails);
            pstmt.executeUpdate(createBedDetails);
            // creating Sequence
            String createBedSeq = " CREATE SEQUENCE BedID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createBedSeq);
            pstmt.executeUpdate(createBedSeq);
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
        try {
            //MEDICAL EQUIPMENT START creating table
            System.out.println("Creating Medical Equipment");
            String createMEquipDetails = "CREATE TABLE MedicalEquipment(Equipment_ID  NUMBER PRIMARY KEY , Equipment_name VARCHAR2(255), Condition VARCHAR2(100))";
            pstmt = conn.prepareStatement(createMEquipDetails);
            pstmt.executeUpdate(createMEquipDetails);
            // creating Sequence
            String createMEquipSeq = " CREATE SEQUENCE EquipID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createMEquipSeq);
            pstmt.executeUpdate(createMEquipSeq);
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
        // Tables with FK created in this section
        try {
            //REFERRAL START creating table
            System.out.println("Creating Referral");
            String createReferral = "CREATE TABLE Referral (GPNumber NUMBER PRIMARY KEY,GPName VARCHAR2(30),GPLocation VARCHAR2(255),Patient_FName VARCHAR2(30)," +
                    "Patient_LName VARCHAR2(30),Patient_DOB DATE,Patient_Address VARCHAR2(255),Patient_Phone VARCHAR2(15)," +
                    "ReasonVisit VARCHAR2(255),Recommendation VARCHAR2(255),Med_Equip_Needed NUMBER,Consultant_Type NUMBER,checked NUMBER,gender VARCHAR2(10),patient_Number NUMBER REFERENCES Patient(patient_Number))";
            pstmt = conn.prepareStatement(createReferral);
            pstmt.executeUpdate(createReferral);
            // creating Sequence
            String createReferralSeq = " CREATE SEQUENCE GPID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createReferralSeq);
            pstmt.executeUpdate(createReferralSeq);
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
//        try {
//            //APPOINTMENT START creating table
//            System.out.println("Creating Appointment");
//            String createApp = "CREATE TABLE Appointment (AppID NUMBER PRIMARY KEY,AppTime NUMBER,AppDate DATE,ReasonVisit VARCHAR2(255)" +
//                    ",patient_Number NUMBER REFERENCES Patient(patient_Number))";
//            pstmt = conn.prepareStatement(createApp);
//            pstmt.executeUpdate(createApp);
//            // creating Sequence
//            String createAppSeq = " CREATE SEQUENCE APPID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createAppSeq);
//            pstmt.executeUpdate(createAppSeq);
//            // Insert data into table
//           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
//                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
//                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
//            pstmt = conn.prepareStatement(insertRef);
//            pstmt.setString(1, "John");
//            pstmt.setString(2, "Dublin");
//            pstmt.setString(3, "Bill");
//            pstmt.setString(4, "McKey");
//            pstmt.setString(5, "02 Jul 1960");
//            pstmt.setString(6, "25 Willow Way Dublin 10");
//            pstmt.setString(7, "0871234567");
//            pstmt.setString(8,"Chest Pain");
//            pstmt.setString(9,"Rest");
//            pstmt.setInt(10,1);
//            pstmt.setInt(10, 3);
//            pstmt.executeUpdate();*/
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }



        try {
            //APPOINTMENT START creating table
            System.out.println("Creating Appointment");
            String createApp = "CREATE TABLE Appointment (AppID NUMBER PRIMARY KEY,ReasonVisit VARCHAR2(255),requiredEquipment NUMBER, requiredConsultant NUMBER,patient_Number NUMBER REFERENCES Patient(patient_Number))";
            pstmt = conn.prepareStatement(createApp);
            pstmt.executeUpdate(createApp);
            // creating Sequence
            String createAppSeq = " CREATE SEQUENCE APPID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createAppSeq);
            pstmt.executeUpdate(createAppSeq);
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }







        // Tables that use FK as Primary Keys in this section
        try {
            //PATIENT CHART START creating table
            System.out.println("Creating Patient Chart");
            String createPatChart = "CREATE TABLE PatientChart (Patient_form VARCHAR2(255)" +
                    ",patient_Number NUMBER PRIMARY KEY REFERENCES Patient(patient_Number))";
            pstmt = conn.prepareStatement(createPatChart);
            pstmt.executeUpdate(createPatChart);
            // creating Sequence
         /*   String createAppSeq = " CREATE SEQUENCE APPID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createAppSeq);
            pstmt.executeUpdate(createAppSeq);*/
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }

        try {
            //PRESCRIPTION START creating table
            System.out.println("Creating Prescription");
            String createMedicine = "CREATE TABLE Prescription (MedicineAmount NUMBER,patient_Number NUMBER PRIMARY KEY REFERENCES Patient(patient_Number)," +
                    "Med_ID NUMBER REFERENCES Medicine (Med_ID))";
            pstmt = conn.prepareStatement(createMedicine);
            pstmt.executeUpdate(createMedicine);
            // creating Sequence
        /*    String createMedSeq = " CREATE SEQUENCE MedID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createMedSeq);
            pstmt.executeUpdate(createMedSeq);*/
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }

        try {
            //PAYMENT  START creating table
            System.out.println("Creating Payment");
            String createPayDetails = "CREATE TABLE Payment (patient_Number NUMBER PRIMARY KEY REFERENCES Patient(patient_Number)" +
                    ", GMSNumber NUMBER REFERENCES MedicalCard(GMSNumber) " +
                    ",Card_ID NUMBER REFERENCES CardDetails(Card_ID)" +
                    ",Policy_number NUMBER REFERENCES HealthInsurance(Policy_number))";
            pstmt = conn.prepareStatement(createPayDetails);
            pstmt.executeUpdate(createPayDetails);
            // creating Sequence
           /* String createInsurSeq = " CREATE SEQUENCE PolicyID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createInsurSeq);
            pstmt.executeUpdate(createInsurSeq);*/
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }

        try {
            //TIME TABLE START creating table
            System.out.println("Creating Time Tables");
            String createTimeDetails = "CREATE TABLE Timetable(Equipment_ID  NUMBER PRIMARY KEY REFERENCES MedicalEquipment(Equipment_ID) , " +
                    "con_ID NUMBER REFERENCES Consultant(con_ID), " +
                    "Bed_ID REFERENCES Bed(Bed_ID))";
            pstmt = conn.prepareStatement(createTimeDetails);
            pstmt.executeUpdate(createTimeDetails);
            // creating Sequence
            /*String createMEquipSeq = " CREATE SEQUENCE EquipID increment by 1 start with 1";
            pstmt = conn.prepareStatement(createMEquipSeq);
            pstmt.executeUpdate(createMEquipSeq);*/
            // Insert data into table
           /* String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone" +
                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
            pstmt = conn.prepareStatement(insertRef);
            pstmt.setString(1, "John");
            pstmt.setString(2, "Dublin");
            pstmt.setString(3, "Bill");
            pstmt.setString(4, "McKey");
            pstmt.setString(5, "02 Jul 1960");
            pstmt.setString(6, "25 Willow Way Dublin 10");
            pstmt.setString(7, "0871234567");
            pstmt.setString(8,"Chest Pain");
            pstmt.setString(9,"Rest");
            pstmt.setInt(10,1);
            pstmt.setInt(10, 3);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }

        try {
            //TIME TABLE START creating table
            System.out.println("Creating XRayTimeTable");
            String create = "CREATE TABLE XRayTimeTable(xRay_ID  NUMBER PRIMARY KEY, time NUMBER, taken VARCHAR2(10),con_Name VARCHAR2(50), AppID NUMBER REFERENCES Appointment(AppID))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);
            // creating Sequence
            create = " CREATE SEQUENCE xRay_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }

        try {
            //TIME TABLE START creating table
            System.out.println("Creating MRITimeTable");
            String create = "CREATE TABLE MRITimeTable(mRI_ID  NUMBER PRIMARY KEY, time NUMBER, taken VARCHAR2(10),con_Name VARCHAR2(50), AppID NUMBER REFERENCES Appointment(AppID))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);
            // creating Sequence
            create = " CREATE SEQUENCE mRI_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
        try {
            //TIME TABLE START creating table
            System.out.println("Creating CTScanTimeTable");
            String create = "CREATE TABLE CTScanTimeTable(cT_ID  NUMBER PRIMARY KEY, time NUMBER, taken VARCHAR2(10),con_Name VARCHAR2(50), AppID NUMBER REFERENCES Appointment(AppID))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);
            // creating Sequence
            create = " CREATE SEQUENCE cT_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }

        try {
            //TIME TABLE START creating table
            System.out.println("Creating consultantTimetable");
            String create = "CREATE TABLE consultantTimetable(conTT_ID  NUMBER PRIMARY KEY, time NUMBER ,con_Name VARCHAR2(50), AppID NUMBER REFERENCES Appointment(AppID))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);
            // creating Sequence
            create = " CREATE SEQUENCE conTT_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        CreateTables cp = new CreateTables();
        cp.openDB();
        cp.dropTables();
        cp.CreateTable();
//        cp.dropTables();

    }
}


//
///**
// * Created by David on 25/02/2015.
// * USING pstmt.setDate doesn't work had to be done as a String for dates
// *if not in form of "DD MMM YY will throw an error
// */
//
//import java.sql.*;
//import java.sql.Date;
//import java.util.*;
//import oracle.jdbc.pool.OracleDataSource;
//
//public class CreateTables {
//    private Connection conn;
//    private PreparedStatement pstmt = null;
//    private Statement stmt = null;
//    private ResultSet rset;
//
//    // Opening Database
//    public Connection openDB() {
//        String url;
//        Scanner in = new Scanner(System.in);
//        try {
//            // Load the Oracle JDBC driver
//            OracleDataSource ods = new OracleDataSource();
//            System.out.println("Type global1 or home");
//            String val = in.next();
//
//            // Tallaght College
//            if (val.equalsIgnoreCase("global1")) {
//                ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
//                ods.setUser("x00093830");
//                ods.setPassword("db02Jul93");
//                conn = ods.getConnection();
//                System.out.println("connected.");
//            }
//            // At Home
//            else if (val.equalsIgnoreCase("home")) {
//                ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521/XE");
//                ods.setUser("system");
//                ods.setPassword("Liverpool18");
//                conn = ods.getConnection();
//                System.out.println("connected.");
//            }
//
//        } catch (Exception e) {
//            System.out.println("Unable to load driver. " + e);
//        }
//        return conn;
//    }
//
//    // Dropping tables and sequences. Dropped in the reverse order than the createTable method
//    public void dropTables() {
//        System.out.println("Checking for existing tables & Sequences");
//
//        try {
//            // Get a Statement object
//            stmt = conn.createStatement();
//            try {
//                stmt.execute("DROP TABLE PatientChart");
//                System.out.println("PatientChart Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // PATIENTCHART END
//            try {
//                stmt.execute("DROP TABLE Prescription");
//                System.out.println("Prescription Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // PRESCRIPTION END
//            try {
//                stmt.execute("DROP TABLE Payment");
//                System.out.println("Payment Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // PAYMENT END
//            try {
//                stmt.execute("DROP TABLE Timetable");
//                System.out.println("Timetable Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // TIME TABLE END
//            // REFERRAL Sequence & Table START
//            try{
//                stmt.execute("DROP SEQUENCE GPID");
//                System.out.println("Referral Sequence dropped.");
//            }catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try{
//                stmt.execute("DROP TABLE Referral");
//                System.out.println("Referral Table dropped");
//            }catch (SQLException ex){
//                // The table doesn't exist
//            }   // REFERRAL END
//            // APPOINTMENT Sequence & Table START
//            try {
//                stmt.execute("DROP SEQUENCE APPID");
//                System.out.println("Appointment Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE Appointment");
//                System.out.println("Appointment Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // APPOINTMENT END
//
//            // ADMIN Sequence & Table START
//            try {
//                stmt.execute("DROP SEQUENCE StaffID");
//                System.out.println("Administration Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE Administration");
//                System.out.println("Administration Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            }   // ADMIN END
//
//
//
//            // CONSULTANT Sequence & Table START
//            try {
//                stmt.execute("DROP SEQUENCE ConID");
//                System.out.println("Consultant Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE Consultant");
//                System.out.println("Consultant Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // CONSULTANT END
//
//            // PATIENT Sequence & Table START
//            try {
//                stmt.execute("DROP SEQUENCE PatientID");
//                System.out.println("Patient Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE Patient");
//                System.out.println("Patient Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // PATIENT END
//
//            // MEDICINE & Table START
//            try {
//                stmt.execute("DROP SEQUENCE MedID");
//                System.out.println("Medicine Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE Medicine");
//                System.out.println("Medicine Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // MEDICINE END
//
//            // CARD DETAILS & Table START
//            try {
//                stmt.execute("DROP SEQUENCE CardID");
//                System.out.println("Card Details Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE CardDetails");
//                System.out.println("CardDetails Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // CARD DETAILS END
//
//            // MEDICAL CARD Sequence & Table START
//            try {
//                stmt.execute("DROP SEQUENCE GMSID");
//                System.out.println("Medical Card Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE MedicalCard");
//                System.out.println("MedicalCard Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // MEDICAL CARD END
//
//            // HEALTH INSURANCE Sequence & Table START
//            try {
//                stmt.execute("DROP SEQUENCE PolicyID");
//                System.out.println("Health Insurance Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE HealthInsurance");
//                System.out.println("HealthInsurance Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // HEALTH INSURANCE END
//
//            // BED Sequence & Table START
//            try {
//                stmt.execute("DROP SEQUENCE BedID");
//                System.out.println("Bed Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE Bed");
//                System.out.println("Bed Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // BED END
//
//            // MEDICAL EQUIPMENT Sequence & Table START
//            try {
//                stmt.execute("DROP SEQUENCE EquipID");
//                System.out.println("Medical Equipment Sequence dropped.");
//            } catch (SQLException ex) {
//                // If in here then the Sequence did not exist
//            }
//            try {
//                stmt.execute("DROP TABLE MedicalEquipment");
//                System.out.println("MedicalEquipment Table dropped");
//            } catch (SQLException ex) {
//                // The table doesn't exist
//            } // MEDICAL EQUIPMENT END
//
//        } catch (SQLException ex) {
//            System.out.println("ERROR: " + ex.getMessage());
//        }
//    }
//
//    public void CreateTable() {
//        try {
//            //ADMIN START creating table
//            System.out.println("Creating Administration");
//            String createAdmin = "CREATE TABLE Administration (staff_ID NUMBER PRIMARY KEY, password VARCHAR2(255))";
//            pstmt = conn.prepareStatement(createAdmin);
//            pstmt.executeUpdate(createAdmin);
//            // creating Sequence
//            String createAdminSeq = " CREATE SEQUENCE StaffID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createAdminSeq);
//            pstmt.executeUpdate(createAdminSeq);
//
//            // Insert data into table
//            String insertAdmin = "INSERT INTO Administration (staff_ID, password) Values(StaffID.nextVal,?)";
//            pstmt = conn.prepareStatement(insertAdmin);
//            pstmt.setString(1, "password");
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        } // END ADMIN
//        try {
//            //CONSULTANT START creating table
//            System.out.println("Creating Consultant");
//            String createCon = "CREATE TABLE Consultant (con_ID NUMBER PRIMARY KEY, con_Name VARCHAR2(255), department VARCHAR2(50), speciality VARCHAR2(50),Password VARCHAR2(20))";
//            pstmt = conn.prepareStatement(createCon);
//            pstmt.executeUpdate(createCon);
//            // creating Sequence
//            String createConSeq = " CREATE SEQUENCE ConID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createConSeq);
//            pstmt.executeUpdate(createConSeq);
//            // Insert data into table
//            String insertCon = "INSERT INTO Consultant (con_ID,con_Name,department,speciality, password) Values(ConID.nextVal,?,?,?,?)";
//            pstmt = conn.prepareStatement(insertCon);
//            pstmt.setString(1, "John");
//            pstmt.setString(2, "Peds");
//            pstmt.setString(3, "feet");
//            pstmt.setString(4, "Password");
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        try {
//            //Patient START creating table
//            System.out.println("Creating Patient");
//            String createPatient = "CREATE TABLE Patient (patient_Number NUMBER PRIMARY KEY, patientFName VARCHAR2(30), patientLName VARCHAR2(30)," +
//                    "PatientDOB DATE,PatientGender VARCHAR2(10), BloodType VARCHAR2(5),Symptoms VARCHAR2(255), Diagnoses VARCHAR2(255), RequiredTreatment " +
//                    "VARCHAR2(255),EquipmentNeeded NUMBER, EquipmentUsed NUMBER,Allergies VARCHAR2(255),PrescriptionUsed VARCHAR2(255),PatientEmail VARCHAR2(30),PatientPhone VARCHAR2(15))";
//            pstmt = conn.prepareStatement(createPatient);
//            pstmt.executeUpdate(createPatient);
//            // creating Sequence
//            String createPatientSeq = " CREATE SEQUENCE PatientID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createPatientSeq);
//            pstmt.executeUpdate(createPatientSeq);
//            // Insert data into table
//            String insertPatient = "INSERT INTO Patient (patient_Number,patientFName,patientLName,PatientDOB,PatientGender,BloodType,Symptoms,Diagnoses,RequiredTreatment," +
//                    "EquipmentNeeded,EquipmentUsed,Allergies,PrescriptionUsed,PatientEmail,PatientPhone) Values(PatientID.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            pstmt = conn.prepareStatement(insertPatient);
//            pstmt.setString(1, "John");
//            pstmt.setString(2, "McKay");
//            pstmt.setString(3, "07-JUL-77");  // NOT SURE ABOUT THIS DOUBLE CHECK
//            pstmt.setString(4,"Male");
//            pstmt.setString(5,"B+");
//            pstmt.setString(6,"Chest Pains");
//            pstmt.setString(7,"Irregular Heartbeat");
//            pstmt.setString(8,"Rest");
//            pstmt.setInt(9, 2);
//            pstmt.setInt(10,2);
//            pstmt.setString(11,"None");
//            pstmt.setString(12,"Aspirin");
//            pstmt.setString(13,"JohnMcKay@Gmail.com");
//            pstmt.setString(14,"0123456789");
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        try {
//            //MEDICINE START creating table
//            System.out.println("Creating Medicine");
//            String createMedicine = "CREATE TABLE Medicine (Med_ID NUMBER PRIMARY KEY, Med_Name VARCHAR2(50)" +
//                    ",Dosage NUMBER, StockLevel NUMBER)";
//            pstmt = conn.prepareStatement(createMedicine);
//            pstmt.executeUpdate(createMedicine);
//            // creating Sequence
//            String createMedSeq = " CREATE SEQUENCE MedID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createMedSeq);
//            pstmt.executeUpdate(createMedSeq);
//            // Insert data into table
//            String insertMed = "INSERT INTO Medicine (Med_ID,Med_Name,Dosage,StockLevel)"
//                   + "Values(MedID.nextVal,?,?,?)";
//            pstmt = conn.prepareStatement(insertMed);
//            pstmt.setString(1,"Aspirin");
//            pstmt.setDouble(2,100.00);
//            pstmt.setInt(3, 50);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        try {
//            //CARD DETAILS START creating table
//            System.out.println("Creating Card Details");
//            String createCardDetails = "CREATE TABLE CardDetails (Card_ID NUMBER PRIMARY KEY NOT NULL, cardType VARCHAR2(30)" +
//                    ",SecurityCode NUMBER,CardHolder VARCHAR2(70),ExpiryDate DATE)";
//            pstmt = conn.prepareStatement(createCardDetails);
//            pstmt.executeUpdate(createCardDetails);
//            // creating Sequence
//            String createCardSeq = " CREATE SEQUENCE CardID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createCardSeq);
//            pstmt.executeUpdate(createCardSeq);
//            // Insert data into table
//            String insertCard = "INSERT INTO CardDetails (Card_ID,cardType,SecurityCode, CardHolder,ExpiryDate) " +
//                    "Values(CardID.nextVal,?,?,?,?)";
//            pstmt = conn.prepareStatement(insertCard);
//            pstmt.setString(1, "Visa");
//            pstmt.setInt(2, 1234);
//            pstmt.setString(3, "John McKay");
//            pstmt.setString(4,"15 AUG 18");  // DATE IN SQL NEEDS DD MMM YY
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        try {
//            //MEDICAL CARD  START creating table
//            System.out.println("Creating Medical Card");
//            String createMCardDetails = "CREATE TABLE MedicalCard (GMSNumber NUMBER PRIMARY KEY, PPSN NUMBER, Gender VARCHAR2(20)" +
//                    ",DOB DATE,ValidTo DATE,HolderName VARCHAR2(70))";
//            pstmt = conn.prepareStatement(createMCardDetails);
//            pstmt.executeUpdate(createMCardDetails);
//            // creating Sequence
//            String createMCardSeq = "CREATE SEQUENCE GMSID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createMCardSeq);
//            pstmt.executeUpdate(createMCardSeq);
//            // Insert data into table
//            String insertMCard = "INSERT INTO MedicalCard (GMSNumber,PPSN,Gender,DOB,ValidTo,HolderName) " +
//                    "Values(GMSID.nextVal,?,?,?,?,?)";
//            pstmt = conn.prepareStatement(insertMCard);
//            pstmt.setInt(1, 8912587); // MAYBE CHANGE TO VARCHAR2 AS PPSN HAVE LETTERS
//            pstmt.setString(2, "Male");
//            pstmt.setString(3, "07-JUL-77");
//            pstmt.setString(4, "17 MAR 16");
//            pstmt.setString(5, "John McKay");
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        try {
//            //HEALTH INSURANCE  START creating table
//            System.out.println("Creating Health Insurance");
//            String createInsurDetails = "CREATE TABLE HealthInsurance(Policy_number NUMBER PRIMARY KEY, Company_name VARCHAR2(255)" +
//                    ",Coverage_type NUMBER,Expiry_date DATE)";
//            pstmt = conn.prepareStatement(createInsurDetails);
//            pstmt.executeUpdate(createInsurDetails);
//            // creating Sequence
//            String createInsurSeq = " CREATE SEQUENCE PolicyID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createInsurSeq);
//            pstmt.executeUpdate(createInsurSeq);
//            // Insert data into table
//            String insertRef = "INSERT INTO HealthInsurance (Policy_number, company_name,Coverage_type,Expiry_date) " +
//                    "Values(PolicyID.nextVal,?,?,?)";
//            pstmt = conn.prepareStatement(insertRef);
//            pstmt.setString(1, "VHI");
//            pstmt.setInt(2, 2);
//            pstmt.setString(3, "27 AUG 15"); // DATE
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        try {
//            //BED  START creating table
//            System.out.println("Creating Bed");
//            String createBedDetails = "CREATE TABLE Bed (Bed_ID NUMBER PRIMARY KEY , CurrentBeds NUMBER, MaxBed NUMBER)";
//            pstmt = conn.prepareStatement(createBedDetails);
//            pstmt.executeUpdate(createBedDetails);
//            // creating Sequence
//            String createBedSeq = " CREATE SEQUENCE BedID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createBedSeq);
//            pstmt.executeUpdate(createBedSeq);
//            // Insert data into table
//            String insertBed = "INSERT INTO Bed (Bed_ID,CurrentBeds,MaxBed) " +
//                    "Values(BedID.nextVal,?,?)";
//            pstmt = conn.prepareStatement(insertBed);
//            pstmt.setInt(1, 25);
//            pstmt.setInt(2, 100);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        try {
//            //MEDICAL EQUIPMENT START creating table
//            System.out.println("Creating Medical Equipment");
//            String createMEquipDetails = "CREATE TABLE MedicalEquipment(Equipment_ID  NUMBER PRIMARY KEY , Equipment_name VARCHAR2(255), Condition VARCHAR2(100))";
//            pstmt = conn.prepareStatement(createMEquipDetails);
//            pstmt.executeUpdate(createMEquipDetails);
//            // creating Sequence
//            String createMEquipSeq = " CREATE SEQUENCE EquipID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createMEquipSeq);
//            pstmt.executeUpdate(createMEquipSeq);
//            // Insert data into table
//            String insertMEquip = "INSERT INTO MedicalEquipment (Equipment_ID,Equipment_name,Condition ) " +
//                    "Values(EquipID.nextVal,?,?)";
//            pstmt = conn.prepareStatement(insertMEquip);
//            pstmt.setString(1, "MRI");
//            pstmt.setString(2, "Good True or false");
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        // Tables with FK created in this section
//        try {
//            //REFERRAL START creating table
//            System.out.println("Creating Referral");
//            String createReferral = "CREATE TABLE Referral (GPNumber NUMBER PRIMARY KEY,GPName VARCHAR2(30),GPLocation VARCHAR2(255),Patient_FName VARCHAR2(30)," +
//                    "Patient_LName VARCHAR2(30),Patient_DOB DATE,Patient_Address VARCHAR2(255),Patient_Phone VARCHAR2(15)," +
//                    "ReasonVisit VARCHAR2(255),Recommendation VARCHAR2(255),Med_Equip_Needed NUMBER,Consultant_Type NUMBER,patient_Number NUMBER REFERENCES Patient(patient_Number))";
//            pstmt = conn.prepareStatement(createReferral);
//            pstmt.executeUpdate(createReferral);
//            // creating Sequence
//            String createReferralSeq = " CREATE SEQUENCE GPID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createReferralSeq);
//            pstmt.executeUpdate(createReferralSeq);
//            // Insert data into table
//            String insertRef = "INSERT INTO Referral (GPNumber,GPName,GPLocation,Patient_FName, Patient_LName,Patient_DOB,Patient_Address,Patient_Phone," +
//                    "ReasonVisit,Recommendation,Med_Equip_Needed,Consultant_Type,patient_Number) " +
//                    "Values(GPID.nextVal,?,?,?,?,?,?,?,?,?,?,?,PatientID.currVal)";
//            pstmt = conn.prepareStatement(insertRef);
//            pstmt.setString(1, "John");
//            pstmt.setString(2, "Dublin");
//            pstmt.setString(3, "John");
//            pstmt.setString(4, "McKay");
//            pstmt.setString(5, "07 JUL 1977");
//            pstmt.setString(6, "25 Willow Way Dublin 10");
//            pstmt.setString(7, "0123456789");
//            pstmt.setString(8,"Chest Pain");
//            pstmt.setString(9,"Rest");
//            pstmt.setInt(10,1);
//            pstmt.setInt(11, 3);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        try {
//            //APPOINTMENT START creating table
//            System.out.println("Creating Appointment");
//            String createApp = "CREATE TABLE Appointment (AppID NUMBER PRIMARY KEY,AppTime NUMBER,AppDate DATE,ReasonVisit VARCHAR2(255)" +
//                    ",patient_Number NUMBER REFERENCES Patient(patient_Number))";
//            pstmt = conn.prepareStatement(createApp);
//            pstmt.executeUpdate(createApp);
//            // creating Sequence
//            String createAppSeq = " CREATE SEQUENCE APPID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createAppSeq);
//            pstmt.executeUpdate(createAppSeq);
//            // Insert data into table
//            String insertApp = "INSERT INTO Appointment (AppID,AppTime,AppDate,ReasonVisit,patient_Number) " +
//                    "Values(APPID.nextVal,?,?,?,PatientID.currVal)";
//            pstmt = conn.prepareStatement(insertApp);
//            pstmt.setInt(1,12);
//            pstmt.setString(2, "23 APR 15");
//            pstmt.setString(3, "Chest Pains");
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//        // Tables that use FK as Primary Keys in this section
//        try {
//            //PATIENT CHART START creating table
//            System.out.println("Creating Patient Chart");
//            String createPatChart = "CREATE TABLE PatientChart (Patient_form VARCHAR2(255)" +
//                    ",patient_Number NUMBER PRIMARY KEY REFERENCES Patient(patient_Number))";
//            pstmt = conn.prepareStatement(createPatChart);
//            pstmt.executeUpdate(createPatChart);
//            // Insert data into table
//            String insertPChart = "INSERT INTO PatientChart (Patient_form,patient_Number) Values(?,PatientID.currVal)";
//            pstmt = conn.prepareStatement(insertPChart);
//            pstmt.setString(1,"PatientChart Test");
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//
//        try {
//            //PRESCRIPTION START creating table
//            System.out.println("Creating Prescription");
//            String createMedicine = "CREATE TABLE Prescription (MedicineAmount NUMBER,patient_Number NUMBER PRIMARY KEY REFERENCES Patient(patient_Number)," +
//                    "Med_ID NUMBER REFERENCES Medicine (Med_ID))";
//            pstmt = conn.prepareStatement(createMedicine);
//            pstmt.executeUpdate(createMedicine);
//            // MIGHT NEED .currVal
//            String insertPres = "INSERT INTO Prescription(MedicineAmount,patient_Number) VALUES (?,PatientID.currVal)";
//            pstmt = conn.prepareStatement(insertPres);
//            pstmt.setInt(1, 30);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//
//        try {
//            //PAYMENT  START creating table
//            System.out.println("Creating Payment");
//            String createPayDetails = "CREATE TABLE Payment (paymentID NUMBER PRIMARY KEY,patient_Number NUMBER REFERENCES Patient(patient_Number)" +
//                    ", GMSNumber NUMBER REFERENCES MedicalCard(GMSNumber) " +
//                    ",Card_ID NUMBER REFERENCES CardDetails(Card_ID)" +
//                    ",Policy_number NUMBER REFERENCES HealthInsurance(Policy_number))";
//            pstmt = conn.prepareStatement(createPayDetails);
//            pstmt.executeUpdate(createPayDetails);
//            // creating Sequence
//            String createPaySeq = " CREATE SEQUENCE PayID increment by 1 start with 1";
//            pstmt = conn.prepareStatement(createPaySeq);
//            pstmt.executeUpdate(createPaySeq);
//            // MIGHT NEED .currVal
//            String insertPay = "INSERT INTO Payment(paymentID,patient_Number,GMSNumber,Card_ID,Policy_number) " +
//                    "VALUES(PayID.nextVal,PatientID.currVal,GMSID.currVal,CardID.currVal,PolicyID.currVal)";
//            pstmt = conn.prepareStatement(insertPay);
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//
//        try {
//            //TIME TABLE START creating table
//            System.out.println("Creating Time Tables");
//            String createTimeDetails = "CREATE TABLE Timetable(Equipment_ID  NUMBER PRIMARY KEY REFERENCES MedicalEquipment(Equipment_ID) , " +
//                    "con_ID NUMBER REFERENCES Consultant(con_ID), " +
//                    "Bed_ID REFERENCES Bed(Bed_ID))";
//            pstmt = conn.prepareStatement(createTimeDetails);
//            pstmt.executeUpdate(createTimeDetails);
//
//            // MIGHT NEED .currVal
//            String insertTime = "INSERT INTO Timetable(Equipment_ID,con_ID,Bed_ID) VALUES(EquipID.currVal,ConID.currVal, BedID.currVal)";
//            pstmt = conn.prepareStatement(insertTime);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.print("SQL Exception " + e);
//            System.exit(1);
//        }
//    }
//
//    public static void main(String args[]) {
//        CreateTables cp = new CreateTables();
//        cp.openDB();
//        cp.dropTables();
//        cp.CreateTable();
////        cp.dropTables();
//    }
//}

