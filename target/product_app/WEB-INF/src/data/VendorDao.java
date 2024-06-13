package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 仕入先データ操作用DAOクラス
public class VendorDao {

    //接続用の情報をフィールドに定数として定義
	 private static final String URL = "jdbc:mariadb://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/qw7b7zlp8nl4pl30";
     private static final String USER_NAME = "nabsix0x3b22ucqc";
     private static final String PASSWORD = "f18cngg97rbo2luj";

    // 仕入先データの読み取り
    public ArrayList<VendorDto> read()
            throws SQLException {

        // SELECT文のフォーマット
        String sql = "SELECT vendor_code FROM vendors;";

        // 取得したデータを格納するためのリスト
        ArrayList<VendorDto> dataList = new ArrayList<VendorDto>();

        // データベース接続 ＆ SQL文の準備
        try (Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                Statement statement = con.createStatement();) {

            // SQL文を実行
            ResultSet result = statement.executeQuery(sql);

            // SQLクエリの実行結果を抽出
            while (result.next()) {
                // DTOのインスタンスにデータをセット
                VendorDto vendorData = new VendorDto();
                vendorData.setVendorCode(result.getInt("vendor_code"));

                // リストにデータを追加
                dataList.add(vendorData);
            }
        }

        return dataList; // データリストを返す
    }
}
