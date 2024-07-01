package mikolaj.michalczyk.finance.API;

import mikolaj.michalczyk.finance.model.ChartResponse;
import mikolaj.michalczyk.finance.model.StockList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    @GET("auto-complete")
    Call<StockList> getStockInfo(@Query("region") String region, @Query("q") String query, @Header("x-rapidapi-key") String apiKey);
    @GET("stock/v3/get-chart")
    Call<ChartResponse> getChart(@Query("interval") String interval, @Query("region") String region, @Query("symbol") String symbol, @Query("range") String range, @Header("x-rapidapi-key") String apiKey);
}
