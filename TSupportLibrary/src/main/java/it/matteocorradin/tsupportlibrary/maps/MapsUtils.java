package it.matteocorradin.tsupportlibrary.maps;

/*public class MapsUtils {

    public static @Nullable CountryIso3 findCountryIso3(@NonNull Context context, @NonNull String alpha3Code){
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open("json/countryIso3.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (json != null){
            Type listType = new TypeToken<List<CountryIso3>>() {}.getType();
            List<CountryIso3> list = new Gson().fromJson(json, listType);
            for (CountryIso3 countryIso3: list){
                if (countryIso3.getAlpha3Code().toLowerCase().equals(alpha3Code.toLowerCase())){
                    return countryIso3;
                }
            }
        }
        return null;
    }

}
*/