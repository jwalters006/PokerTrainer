package com.rallymonkey911.android.pokertrainer;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 4/25/2017.
 */

final class MapLookup {

    private MapLookup() {}

    static String lookUpInMap(Context context, String sortedTomHandString,
                                     String gameSelected) {
        String firstCard = sortedTomHandString.substring(0,PokerAsyncTask.CODE_LENGTH_ONE_CARD).toLowerCase();
        String secondCard = sortedTomHandString.substring(PokerAsyncTask.CODE_LENGTH_ONE_CARD,
                PokerAsyncTask.CODE_LENGTH_ONE_CARD*2).toLowerCase();
        String firstTwoCards = firstCard + secondCard;
        InputStream resource;
        String resourcePrefix;
        String resourceSuffix;
        if (gameSelected.equals(context.getString(R.string.jacks_or_better))) {
            resourcePrefix = "test_hash_map_";
        } else {
            resourcePrefix = "dw_map_";
        }

        resourceSuffix = convertHandToSerialFileName(firstCard, secondCard);

        // Create HashMap from serialized object
        try {
            String resourceString = resourcePrefix+resourceSuffix;
            int resourceId = context.getResources().getIdentifier(resourceString, "raw", context.getPackageName());
            resource = context.getResources().openRawResource(resourceId);
            BufferedInputStream bufferedFileIn = new BufferedInputStream(resource);
            ObjectInputStream in = new ObjectInputStream(bufferedFileIn);
            Map map = (HashMap) in.readObject();
            in.close();
            bufferedFileIn.close();
            resource.close();
            String result = (String) map.get(sortedTomHandString);
            map = null;
            return result;
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Map class not found");
            c.printStackTrace();
        }
        return "";
    }

    static String convertHandToSerialFileName(String firstCard, String secondCard){

        HashMap<String,Integer> cardValueMap = new HashMap<>(52);
        int i = 1;
        String[] ranks = {"a", "2", "3", "4", "5", "6", "7", "8", "9", "t", "j", "q", "k"};
        String[] suits = {"s", "h", "d", "c"};
        for (String suit : suits){
            for (String rank : ranks){
                cardValueMap.put(rank+suit, i++);
            }
        }

        String[] serializedFileNames = {
                "2h3h_2h8h", "2h9h_2htc", "2s2h_2s7h", "2s3s_2s4s", "2s5s_2s6s", "2s7s_2s8s",
                "2s8h_2skh", "2s9s_2sjs", "2sad_2stc", "2sqs_2sah", "3h4h_3h9h", "3hth_3htc",
                "3s4s_3s5s", "3s6h_3skh", "3s6s_3s7s", "3s8s_3sts", "3sad_3stc", "3sah_3s5h",
                "3sjs_3sks", "4h5h_4hkh", "4had_4htc", "4s5s_4s6s", "4s6h_4skh", "4s7s_4s8s",
                "4s9s_4sjs", "4sad_4stc", "4sah_4s5h", "4sqs_4sks", "5d6d_kdtc", "5h6h_5htc",
                "5s4h_5s9h", "5s6s_5s8s", "5s9s_5sqs", "5sks_5s3h", "5sth_5stc", "6h7h_6htc",
                "6s6h_6skh", "6s7s_6s9s", "6sad_6stc", "6sah_6s5h", "6sts_6sks", "7h8h_7htc",
                "7s7h_7skh", "7s8s_7sts", "7sad_7stc", "7sah_7s6h", "7sjs_7sks", "8h9h_8htc",
                "8s7h_8skh", "8s9s_8sjs", "8sad_8stc", "8sah_8s6h", "8sqs_8sks", "9hth_9htc",
                "9s7h_9skh", "9sad_9stc", "9sah_9s6h", "9sts_9sks", "ac2c_9ctc", "ad2d_4dtc",
                "ah2h_ah8h", "ah9h_ahkh", "ahad_ahtc", "as2s_as3s", "as4s_as5s", "as5h_askh",
                "as6s_as7s", "as8s_as9s", "asad_astc", "asah_as4h", "asqs_asks", "asts_asjs",
                "js4h_jskh", "jsad_jstc", "jsqs_js3h", "ks7h_kskh", "ksad_kstc", "ksah_ks6h",
                "qhkh_khtc", "qs5h_qskh", "qsad_qstc", "qsks_qs4h", "thjh_jhtc", "ts7h_tskh",
                "tsad_tstc", "tsah_ts6h", "tsjs_tsks"};

        // If the value of the first card in the hand is greater than or equal to
        // the first card in the file name, and the second card is greater than or equal to
        // the second card in the file name

        // AND

        // the first card in the hand is less than or equal to the third card in the file name,
        // and the second card in the hand is less than or equal to the fourth card in the file name

        // THEN

        // return the serialized file name (serFileName) as the resourceSuffix

        // e.g., as8d ----> will return "asad_astc"

        for (String serFileName : serializedFileNames){
            if (
                    (cardValueMap.get(firstCard) >= cardValueMap.get(serFileName.substring(0,2))) &&
                            (cardValueMap.get(secondCard) >= cardValueMap.get(serFileName.substring(2,4))) &&
                            (cardValueMap.get(firstCard) <= cardValueMap.get(serFileName.substring(5,7))) &&
                            (cardValueMap.get(secondCard) <= cardValueMap.get(serFileName.substring(7,9)))
                    )  {
                return serFileName;
            }
        }

        return "";
    }
}
