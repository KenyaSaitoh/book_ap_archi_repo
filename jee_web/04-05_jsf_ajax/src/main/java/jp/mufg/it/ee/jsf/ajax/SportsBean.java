package jp.mufg.it.ee.jsf.ajax;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named("sportsBean")
public class SportsBean implements Serializable {
    // 選択値を保持するためのプロパティ（フィールドとアクセサ）
    private String sports;
    private String position;

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
        // スポーツを選択したら、ポジションはクリアする
        this.position = null;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // スポーツのセレクトメニューのためのプロパティ（フィールドとアクセサ）
    private Map<String, String> sportsMap = new LinkedHashMap<String, String>();
    private Map<String, String> positionMap = new LinkedHashMap<String, String>();
    public Map<String, String> getSportsMap() {
        if (sportsMap.isEmpty()) {
            sportsMap.put("== 選択して下さい ==", "");
            sportsMap.put("野球", "野球");
            sportsMap.put("サッカー", "サッカー");
        }
        return sportsMap;
    }

    public void setSportsMap(Map<String, String> sportsMap) {
        this.sportsMap = sportsMap;
    }

    public Map<String, String> getPositionMap() {
        if (sports == null) return null;
        positionMap.clear();
        if (sports.equals("野球")) {
            positionMap.put("== 選択して下さい ==", "");
            positionMap.put("ピッチャー", "ピッチャー");
            positionMap.put("キャッチャー", "キャッチャー");
            positionMap.put("内野手", "内野手");
            positionMap.put("外野手", "外野手");
        } else if (sports.equals("サッカー")) {
            positionMap.put("== 選択して下さい ==", "");
            positionMap.put("フォワード", "フォワード");
            positionMap.put("ミッドフィールダー", "ミッドフィールダー");
            positionMap.put("ディフェンダー", "ディフェンダー");
            positionMap.put("ゴールキーパー", "ゴールキーパー");
        }
        return positionMap;
    }

    public void setPositionMap(Map<String, String> positionMap) {
        this.positionMap = positionMap;
    }
}