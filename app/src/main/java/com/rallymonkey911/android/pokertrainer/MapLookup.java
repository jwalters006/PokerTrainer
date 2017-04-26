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

public class MapLookup {

    private MapLookup() {}

    public static String lookUpInMap(Context context, String sortedTomHandString) {
        String firstCard = sortedTomHandString.substring(0, 2);
        InputStream resource;

        switch (firstCard) {
            case "AS":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_as);
                break;
            case "2S":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_2s);
                break;
            case "3S":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_3s);
                break;
            case "4S":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_4s);
                break;
            case "5S":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_5s);
                break;
            case "6S":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_6s);
                break;
            case "7S":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_7s);
                break;
            case "8S":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_8s);
                break;
            case "9S":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_9s);
                break;
            case "TS":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_ts);
                break;
            case "JS":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_js);
                break;
            case "QS":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_qs);
                break;
            case "KS":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_ks);
                break;
            case "AH":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_ah);
                break;
            case "2H":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_2h);
                break;
            case "3H":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_3h);
                break;
            case "4H":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_4h);
                break;
            case "5h":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_5h);
                break;
            case "6H":case "7H":case "8H":case "9H":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_6h_9h);
                break;
            case "TH":case "JH":case "QH":case "KH":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_th_kh);
                break;
            case "AD":case "2D":case "3D":case "4D":case "5D":case "6D":case "7D":case "8D":
            case "9D":case "TD":case "JD":case "QD":case "KD":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_d);
                break;
            case "AC":case "2C":case "3C":case "4C":case "5C":case "6C":case "7C":case "8C":
            case "9C":case "TC":case "JC":case "QC":case "KC":
                resource = context.getResources().openRawResource(
                        R.raw.test_hash_map_c);
                break;
            default:
                resource = null;
                break;
        }

        // Create HashMap from serialized object
        try {
            InputStream fileIn = resource;
            BufferedInputStream bufferedFileIn = new BufferedInputStream(fileIn);
            ObjectInputStream in = new ObjectInputStream(bufferedFileIn);
            Map map = (HashMap) in.readObject();
            in.close();
            bufferedFileIn.close();
            fileIn.close();
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
}
