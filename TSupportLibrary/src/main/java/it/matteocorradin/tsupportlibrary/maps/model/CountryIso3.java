
package it.matteocorradin.tsupportlibrary.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryIso3 implements Parcelable
{

    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Alpha-2 code")
    @Expose
    private String alpha2Code;
    @SerializedName("Alpha-3 code")
    @Expose
    private String alpha3Code;
    @SerializedName("Numeric code")
    @Expose
    private Integer numericCode;
    @SerializedName("Latitude (average)")
    @Expose
    private Double latitudeAverage;
    @SerializedName("Longitude (average)")
    @Expose
    private Double longitudeAverage;
    public final static Creator<CountryIso3> CREATOR = new Creator<CountryIso3>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CountryIso3 createFromParcel(Parcel in) {
            return new CountryIso3(in);
        }

        public CountryIso3[] newArray(int size) {
            return (new CountryIso3[size]);
        }

    }
    ;

    protected CountryIso3(Parcel in) {
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.alpha2Code = ((String) in.readValue((String.class.getClassLoader())));
        this.alpha3Code = ((String) in.readValue((String.class.getClassLoader())));
        this.numericCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.latitudeAverage = ((Double) in.readValue((Double.class.getClassLoader())));
        this.longitudeAverage = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public CountryIso3() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public Integer getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(Integer numericCode) {
        this.numericCode = numericCode;
    }

    public Double getLatitudeAverage() {
        return latitudeAverage;
    }

    public void setLatitudeAverage(Double latitudeAverage) {
        this.latitudeAverage = latitudeAverage;
    }

    public Double getLongitudeAverage() {
        return longitudeAverage;
    }

    public void setLongitudeAverage(Double longitudeAverage) {
        this.longitudeAverage = longitudeAverage;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(country);
        dest.writeValue(alpha2Code);
        dest.writeValue(alpha3Code);
        dest.writeValue(numericCode);
        dest.writeValue(latitudeAverage);
        dest.writeValue(longitudeAverage);
    }

    public int describeContents() {
        return  0;
    }

}
