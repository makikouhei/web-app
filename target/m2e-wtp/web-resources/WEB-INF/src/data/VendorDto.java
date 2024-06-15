package data;

// 仕入先データ受け渡し用DTOクラス
public class VendorDto {
    private int vendorCode = 0; // 仕入先コード

    // 現在の仕入先コードを取得する
    public int getVendorCode() {
        return this.vendorCode;
    }

    // 仕入先コードに新しいデータを設定する
    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
    }
}
