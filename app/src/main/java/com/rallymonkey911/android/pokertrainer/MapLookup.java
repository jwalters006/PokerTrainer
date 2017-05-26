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

    public static final String GAME_SELECTION_JACKS = "Jacks or Better";
    public static final String GAME_SELECTION_DEUCES = "Deuces Wild";



    private MapLookup() {}

    public static String lookUpInMap(Context context, String sortedTomHandString,
                                     String gameSelected) {
        String firstCard = sortedTomHandString.substring(0,PokerAsyncTask.CODE_LENGTH_ONE_CARD);
        String secondCard = sortedTomHandString.substring(PokerAsyncTask.CODE_LENGTH_ONE_CARD,
                PokerAsyncTask.CODE_LENGTH_ONE_CARD*2);
        String firstTwoCards = firstCard + secondCard;
        InputStream resource;
        String resourcePrefix;
        String resourceSuffix;
        if (gameSelected.equals(GAME_SELECTION_JACKS)) {
            resourcePrefix = "test_hash_map_";
        } else {
            resourcePrefix = "dw_map_";
        }

        switch(firstCard) {
            case "5H":case "6H":case "7H":case "8H":case "9H":case "TH":case "JH":case "QH":
            case "KH":case "AD":case "2D":case "3D":case "4D":case "5D":case "6D":case "7D":
            case "8D":case "9D":case "TD":case "JD":case "QD":case "KD":case "AC":case "2C":
            case "3C":case "4C":case "5C":case "6C":case "7C":case "8C":case "9C":case "TC":
                switch (firstCard) {
                    case "5H":
                        resourceSuffix = "5h";
                        break;
                    case "6H":
                        resourceSuffix = "6h";
                        break;
                    case "7H":
                        resourceSuffix = "7h";
                        break;
                    case "8H":
                        resourceSuffix = "8h";
                        break;
                    case "9H":
                        resourceSuffix = "9h";
                        break;
                    case "TH":case "JH":
                        resourceSuffix = "th_jh";
                        break;
                    case "QH":case "KH":
                        resourceSuffix = "qh_kh";
                        break;
                    case "AD":case "2D":case "3D":case "4D":
                        resourceSuffix = "ad_thru_4d";
                        break;
                    case "5D":case "6D":case "7D":case "8D":case "9D":case "TD":case "JD":
                    case "QD":case "KD":
                        resourceSuffix = "5d_thru_kd";
                        break;
                    default:
                        resourceSuffix = "c";
                        break;
                }
                break;

            default:
                switch (firstTwoCards) {
                    case "AS2S":case "AS3S":
                        resourceSuffix = "as2s_as3s";
                        break;
                    case "AS4S":case "AS5S":
                        resourceSuffix = "as4s_as5s";
                        break;
                    case "AS6S":case "AS7S":
                        resourceSuffix = "as6s_as7s";
                        break;
                    case "AS8S":case "AS9S":
                        resourceSuffix = "as8s_as9s";
                        break;
                    case "ASTS":case "ASJS":
                        resourceSuffix = "asts_asjs";
                        break;
                    case "ASQS":case "ASKS":
                        resourceSuffix = "asqs_asks";
                        break;
                    case "ASAH":case "AS2H":case "AS3H":case "AS4H":
                        resourceSuffix = "asah_as2h_as3h_as4h";
                        break;
                    case "AS5H":case "AS6H":case "AS7H":case "AS8H":case "AS9H":
                    case "ASTH":case "ASJH":case "ASQH":case "ASKH":
                        resourceSuffix = "as5h_as6h_as7h_as8h_as9h_asth_asjh_asqh_askh";
                        break;
                    case "ASAD":case "AS2D":case "AS3D":case "AS4D":case "AS5D":case "AS6D":
                    case "AS7D":case "AS8D":case "AS9D":case "ASTD":case "ASJD":case "ASQD":
                    case "ASKD":case "ASAC":case "AS2C":case "AS3C":case "AS4C":case "AS5C":
                    case "AS6C":case "AS7C":case "AS8C":case "AS9C":case "ASTC":
                        resourceSuffix = "asad_thru_astc";
                        break;
                    case "2S3S":case "2S4S":
                        resourceSuffix = "2s3s_2s4s";
                        break;
                    case "2S5S":case "2S6S":
                        resourceSuffix = "2s5s_2s6s";
                        break;
                    case "2S7S":case "2S8S":
                        resourceSuffix = "2s7s_2s8s";
                        break;
                    case "2S9S":case "2STS":case "2SJS":
                        resourceSuffix = "2s9s_2sts_2sjs";
                        break;
                    case "2SQS":case "2SKS":case "2SAH":
                        resourceSuffix = "2sqs_2sks_2sah";
                        break;
                    case "2S2H":case "2S3H":case "2S4H":case "2S5H":case "2S6H":case "2S7H":
                        resourceSuffix = "2s2h_2s3h_2s4h_2s5h_2s6h_2s7h";
                        break;
                    case "2S8H":case "2S9H":case "2STH":case "2SJH":case "2SQH":case "2SKH":
                        resourceSuffix = "2s8h_2s9h_2sth_2sjh_2sqh_2skh";
                        break;
                    case "2SAD":case "2S2D":case "2S3D":case "2S4D":case "2S5D":case "2S6D":
                    case "2S7D":case "2S8D":case "2S9D":case "2STD":case "2SJD":case "2SQD":
                    case "2SKD":case "2SAC":case "2S2C":case "2S3C":case "2S4C":case "2S5C":
                    case "2S6C":case "2S7C":case "2S8C":case "2S9C":case "2STC":
                        resourceSuffix = "2sad_thru_2stc";
                        break;
                    case "3S4S":case "3S5S":
                        resourceSuffix = "3s4s_3s5s";
                        break;
                    case "3S6S":case "3S7S":
                        resourceSuffix = "3s6s_3s7s";
                        break;
                    case "3S8S":case "3S9S":case "3STS":
                        resourceSuffix = "3s8s_3s9s_3sts";
                        break;
                    case "3SJS":case "3SQS":case "3SKS":
                        resourceSuffix = "3sjs_3sqs_3sks";
                        break;
                    case "3SAH":case "3S2H":case "3S3H":case "3S4H":case "3S5H":
                        resourceSuffix = "3sah_3s2h_3s3h_3s4h_3s5h";
                        break;
                    case "3S6H":case "3S7H":case "3S8H":case "3S9H":case "3STH":case "3SJH":
                    case "3SQH":case "3SKH":
                        resourceSuffix = "3s6h_3s7h_3s8h_3s9h_3sth_3sjh_3sqh_3skh";
                        break;
                    case "3SAD":case "3S2D":case "3S3D":case "3S4D":case "3S5D":case "3S6D":
                    case "3S7D":case "3S8D":case "3S9D":case "3STD":case "3SJD":case "3SQD":
                    case "3SKD":case "3SAC":case "3S2C":case "3S3C":case "3S4C":case "3S5C":
                    case "3S6C":case "3S7C":case "3S8C":case "3S9C":case "3STC":
                        resourceSuffix = "3sad_thru_3stc";
                        break;
                    case "4S5S":case "4S6S":
                        resourceSuffix = "4s5s_4s6s";
                        break;
                    case "4S7S":case "4S8S":
                        resourceSuffix = "4s7s_4s8s";
                        break;
                    case "4S9S":case "4STS":case "4SJS":
                        resourceSuffix = "4s9s_4sts_4sjs";
                        break;
                    case "4SQS":case "4SKS":
                        resourceSuffix = "4sqs_4sks";
                        break;
                    case "4SAH":case "4S2H":case "4S3H":case "4S4H":case "4S5H":
                        resourceSuffix = "4sah_4s2h_4s3h_4s4h_4s5h";
                        break;
                    case "4S6H":case "4S7H":case "4S8H":case "4S9H":case "4STH":case "4SJH":
                    case "4SQH":case "4SKH":
                        resourceSuffix = "4s6h_4s7h_4s8h_4s9h_4sth_4sjh_4sqh_4skh";
                        break;
                    case "4SAD":case "4S2D":case "4S3D":case "4S4D":case "4S5D":case "4S6D":
                    case "4S7D":case "4S8D":case "4S9D":case "4STD":case "4SJD":case "4SQD":
                    case "4SKD":case "4SAC":case "4S2C":case "4S3C":case "4S4C":case "4S5C":
                    case "4S6C":case "4S7C":case "4S8C":case "4S9C":case "4STC":
                        resourceSuffix = "4sad_thru_4stc";
                        break;
                    case "5S6S":case "5S7S":case "5S8S":
                        resourceSuffix = "5s6s_5s7s_5s8s";
                        break;
                    case "5S9S":case "5STS":case "5SJS":case "5SQS":
                        resourceSuffix = "5s9s_5sts_5sjs_5sqs";
                        break;
                    case "5SKS":case "5SAH":case "5S2H":case "5S3H":
                        resourceSuffix = "5sks_5sah_5s2h_5s3h";
                        break;
                    case "5S4H":case "5S5H":case "5S6H":case "5S7H":case "5S8H":case "5S9H":
                        resourceSuffix = "5s4h_5s5h_5s6h_5s7h_5s8h_5s9h";
                        break;
                    case "5STH":case "5SJH":case "5SQH":case "5SKH":case "5SAD":case "5S2D":
                    case "5S3D":case "5S4D":case "5S5D":case "5S6D":case "5S7D":case "5S8D":
                    case "5S9D":case "5STD":case "5SJD":case "5SQD":case "5SKD":case "5SAC":
                    case "5S2C":case "5S3C":case "5S4C":case "5S5C":case "5S6C":case "5S7C":
                    case "5S8C":case "5S9C":case "5STC":
                        resourceSuffix = "5sth_5sjh_5sqh_5skh_5sad_thru_5stc";
                        break;
                    case "6S7S":case "6S8S":case "6S9S":
                        resourceSuffix = "6s7s_6s8s_6s9s";
                        break;
                    case "6STS":case "6SJS":case "6SQS":case "6SKS":
                        resourceSuffix = "6sts_6sjs_6sqs_6sks";
                        break;
                    case "6SAH":case "6S2H":case "6S3H":case "6S4H":case "6S5H":
                        resourceSuffix = "6sah_6s2h_6s3h_6s4h_6s5h";
                        break;
                    case "6S6H":case "6S7H":case "6S8H":case "6S9H":case "6STH":case "6SJH":
                    case "6SQH":case "6SKH":
                        resourceSuffix = "6s6h_6s7h_6s8h_6s9h_6sth_6sjh_6sqh_6skh";
                        break;
                    case "6SAD":case "6S2D":case "6S3D":case "6S4D":case "6S5D":case "6S6D":
                    case "6S7D":case "6S8D":case "6S9D":case "6STD":case "6SJD":case "6SQD":
                    case "6SKD":case "6SAC":case "6S2C":case "6S3C":case "6S4C":case "6S5C":
                    case "6S6C":case "6S7C":case "6S8C":case "6S9C":case "6STC":
                        resourceSuffix = "6sad_thru_6stc";
                        break;
                    case "7S8S":case "7S9S":case "7STS":
                        resourceSuffix = "7s8s_7s9s_7sts";
                        break;
                    case "7SJS":case "7SQS":case "7SKS":
                        resourceSuffix = "7sjs_7sqs_7sks";
                        break;
                    case "7SAH":case "7S2H":case "7S3H":case "7S4H":case "7S5H":case "7S6H":
                        resourceSuffix = "7sah_7s2h_7s3h_7s4h_7s5h_7s6h";
                        break;
                    case "7S7H":case "7S8H":case "7S9H":case "7STH":case "7SJH":case "7SQH":
                    case "7SKH":
                        resourceSuffix = "7s7h_7s8h_7s9h_7sth_7sjh_7sqh_7skh";
                        break;
                    case "7SAD":case "7S2D":case "7S3D":case "7S4D":case "7S5D":case "7S6D":
                    case "7S7D":case "7S8D":case "7S9D":case "7STD":case "7SJD":case "7SQD":
                    case "7SKD":case "7SAC":case "7S2C":case "7S3C":case "7S4C":case "7S5C":
                    case "7S6C":case "7S7C":case "7S8C":case "7S9C":case "7STC":
                        resourceSuffix = "7sad_thru_7stc";
                        break;
                    case "8S9S":case "8STS":case "8SJS":
                        resourceSuffix = "8s9s_8sts_8sjs";
                        break;
                    case "8SQS":case "8SKS":
                        resourceSuffix = "8sqs_8sks";
                        break;
                    case "8SAH":case "8S2H":case "8S3H":case "8S4H":case "8S5H":case "8S6H":
                        resourceSuffix = "8sah_8s2h_8s3h_8s4h_8s5h_8s6h";
                        break;
                    case "8S7H":case "8S8H":case "8S9H":case "8STH":case "8SJH":case "8SQH":
                    case "8SKH":
                        resourceSuffix = "8s7h_8s8h_8s9h_8sth_8sjh_8sqh_8skh";
                        break;
                    case "8SAD":case "8S2D":case "8S3D":case "8S4D":case "8S5D":case "8S6D":
                    case "8S7D":case "8S8D":case "8S9D":case "8STD":case "8SJD":case "8SQD":
                    case "8SKD":case "8SAC":case "8S2C":case "8S3C":case "8S4C":case "8S5C":
                    case "8S6C":case "8S7C":case "8S8C":case "8S9C":case "8STC":
                        resourceSuffix = "8sad_thru_8stc";
                        break;
                    case "9STS":case "9SJS":case "9SQS":case "9SKS":
                        resourceSuffix = "9sts_9sjs_9sqs_9sks";
                        break;
                    case "9SAH":case "9S2H":case "9S3H":case "9S4H":case "9S5H":case "9S6H":
                        resourceSuffix = "9sah_9s2h_9s3h_9s4h_9s5h_9s6h";
                        break;
                    case "9S7H":case "9S8H":case "9S9H":case "9STH":case "9SJH":case "9SQH":
                    case "9SKH":
                        resourceSuffix = "9s7h_9s8h_9s9h_9sth_9sjh_9sqh_9skh";
                        break;
                    case "9SAD":case "9S2D":case "9S3D":case "9S4D":case "9S5D":case "9S6D":
                    case "9S7D":case "9S8D":case "9S9D":case "9STD":case "9SJD":case "9SQD":
                    case "9SKD":case "9SAC":case "9S2C":case "9S3C":case "9S4C":case "9S5C":
                    case "9S6C":case "9S7C":case "9S8C":case "9S9C":case "9STC":
                        resourceSuffix = "9sad_thru_9stc";
                        break;
                    case "TSJS":case "TSQS":case "TSKS":
                        resourceSuffix = "tsjs_tsqs_tsks";
                        break;
                    case "TSAH":case "TS2H":case "TS3H":case "TS4H":case "TS5H":case "TS6H":
                        resourceSuffix = "tsah_ts2h_ts3h_ts4h_ts5h_ts6h";
                        break;
                    case "TS7H":case "TS8H":case "TS9H":case "TSTH":case "TSJH":case "TSQH":
                    case "TSKH":
                        resourceSuffix = "ts7h_ts8h_ts9h_tsth_tsjh_tsqh_tskh";
                        break;
                    case "TSAD":case "TS2D":case "TS3D":case "TS4D":case "TS5D":case "TS6D":
                    case "TS7D":case "TS8D":case "TS9D":case "TSTD":case "TSJD":case "TSQD":
                    case "TSKD":case "TSAC":case "TS2C":case "TS3C":case "TS4C":case "TS5C":
                    case "TS6C":case "TS7C":case "TS8C":case "TS9C":case "TSTC":
                        resourceSuffix = "tsad_thru_tstc";
                        break;
                    case "JSQS":case "JSKS":case "JSAH":case "JS2H":case "JS3H":
                        resourceSuffix = "jsqs_jsks_jsah_js2h_js3h";
                        break;
                    case "JS4H":case "JS5H":case "JS6H":case "JS7H":case "JS8H":case "JS9H":
                    case "JSTH":case "JSJH":case "JSQH":case "JSKH":
                        resourceSuffix = "js4h_js5h_js6h_js7h_js8h_js9h_jsth_jsjh_jsqh_jskh";
                        break;
                    case "JSAD":case "JS2D":case "JS3D":case "JS4D":case "JS5D":case "JS6D":
                    case "JS7D":case "JS8D":case "JS9D":case "JSTD":case "JSJD":case "JSQD":
                    case "JSKD":case "JSAC":case "JS2C":case "JS3C":case "JS4C":case "JS5C":
                    case "JS6C":case "JS7C":case "JS8C":case "JS9C":case "JSTC":
                        resourceSuffix = "jsad_thru_jstc";
                        break;
                    case "QSKS":case "QSAH":case "QS2H":case "QS3H":case "QS4H":
                        resourceSuffix = "qsks_qsah_qs2h_qs3h_qs4h";
                        break;
                    case "QS5H":case "QS6H":case "QS7H":case "QS8H":case "QS9H":case "QSTH":
                    case "QSJH":case "QSQH":case "QSKH":
                        resourceSuffix = "qs5h_qs6h_qs7h_qs8h_qs9h_qsth_qsjh_qsqh_qskh";
                        break;
                    case "QSAD":case "QS2D":case "QS3D":case "QS4D":case "QS5D":case "QS6D":
                    case "QS7D":case "QS8D":case "QS9D":case "QSTD":case "QSJD":case "QSQD":
                    case "QSKD":case "QSAC":case "QS2C":case "QS3C":case "QS4C":case "QS5C":
                    case "QS6C":case "QS7C":case "QS8C":case "QS9C":case "QSTC":
                        resourceSuffix = "qsad_thru_qstc";
                        break;
                    case "KSAH":case "KS2H":case "KS3H":case "KS4H":case "KS5H":case "KS6H":
                        resourceSuffix = "ksah_ks2h_ks3h_ks4h_ks5h_ks6h";
                        break;
                    case "KS7H":case "KS8H":case "KS9H":case "KSTH":case "KSJH":case "KSQH":
                    case "KSKH":
                        resourceSuffix = "ks7h_ks8h_ks9h_ksth_ksjh_ksqh_kskh";
                        break;
                    case "KSAD":case "KS2D":case "KS3D":case "KS4D":case "KS5D":case "KS6D":
                    case "KS7D":case "KS8D":case "KS9D":case "KSTD":case "KSJD":case "KSQD":
                    case "KSKD":case "KSAC":case "KS2C":case "KS3C":case "KS4C":case "KS5C":
                    case "KS6C":case "KS7C":case "KS8C":case "KS9C":case "KSTC":
                        resourceSuffix = "ksad_thru_kstc";
                        break;
                    case "AH2H":case "AH3H":case "AH4H":case "AH5H":case "AH6H":case "AH7H":
                    case "AH8H":
                        resourceSuffix = "ah2h_ah3h_ah4h_ah5h_ah6h_ah7h_ah8h";
                        break;
                    case "AH9H":case "AHTH":case "AHJH":case "AHQH":case "AHKH":
                        resourceSuffix = "ah9h_ahth_ahjh_ahqh_ahkh";
                        break;
                    case "AHAD":case "AH2D":case "AH3D":case "AH4D":case "AH5D":case "AH6D":
                    case "AH7D":case "AH8D":case "AH9D":case "AHTD":case "AHJD":case "AHQD":
                    case "AHKD":case "AHAC":case "AH2C":case "AH3C":case "AH4C":case "AH5C":
                    case "AH6C":case "AH7C":case "AH8C":case "AH9C":case "AHTC":
                        resourceSuffix = "ahad_thru_ahtc";
                        break;
                    case "2H3H":case "2H4H":case "2H5H":case "2H6H":case "2H7H":case "2H8H":
                        resourceSuffix = "2h3h_2h4h_2h5h_2h6h_2h7h_2h8h";
                        break;
                    case "2H9H":case "2HTH":case "2HJH":case "2HQH":case "2HKH":case "2HAD":
                    case "2H2D":case "2H3D":case "2H4D":case "2H5D":case "2H6D":case "2H7D":
                    case "2H8D":case "2H9D":case "2HTD":case "2HJD":case "2HQD":case "2HKD":
                    case "2HAC":case "2H2C":case "2H3C":case "2H4C":case "2H5C":case "2H6C":
                    case "2H7C":case "2H8C":case "2H9C":case "2HTC":
                        resourceSuffix = "2h9h_thru_2htc";
                        break;
                    case "3H4H":case "3H5H":case "3H6H":case "3H7H":case "3H8H":case "3H9H":
                        resourceSuffix = "3h4h_3h5h_3h6h_3h7h_3h8h_3h9h";
                        break;
                    case "3HTH":case "3HJH":case "3HQH":case "3HKH":case "3HAD":case "3H2D":
                    case "3H3D":case "3H4D":case "3H5D":case "3H6D":case "3H7D":case "3H8D":
                    case "3H9D":case "3HTD":case "3HJD":case "3HQD":case "3HKD":case "3HAC":
                    case "3H2C":case "3H3C":case "3H4C":case "3H5C":case "3H6C":case "3H7C":
                    case "3H8C":case "3H9C":case "3HTC":
                        resourceSuffix = "3hth_thru_3htc";
                        break;
                    case "4H5H":case "4H6H":case "4H7H":case "4H8H":case "4H9H":case "4HTH":
                    case "4HJH":case "4HQH":case "4HKH":
                        resourceSuffix = "4h5h_4h6h_4h7h_4h8h_4h9h_4hth_4hjh_4hqh_4hkh";
                        break;
                    case "4HAD":case "4H2D":case "4H3D":case "4H4D":case "4H5D":case "4H6D":
                    case "4H7D":case "4H8D":case "4H9D":case "4HTD":case "4HJD":case "4HQD":
                    case "4HKD":case "4HAC":case "4H2C":case "4H3C":case "4H4C":case "4H5C":
                    case "4H6C":case "4H7C":case "4H8C":case "4H9C":case "4HTC":
                        resourceSuffix = "4had_thru_4htc";
                        break;
                    default:
                        resourceSuffix = null;
                        break;
                }
        }

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
}
