package com.mit.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

  private static final Logger logger = 
      LoggerFactory.getLogger(UploadFileUtils.class);

  // �뙆�씪 ���옣 寃쎈줈(uploadPath), �썝蹂� �뙆�씪 �씠由�(originalName), �뙆�씪 �뜲�씠�꽣( byte[] fileData) 3媛쒖쓽 �뜲�씠�꽣瑜� �뙆�씪誘명꽣濡� �쟾�넚諛쏅뒗 uploadFile()�븿�닔
  public static String uploadFile(String uploadPath, 
                              String originalName, 
                              byte[] fileData)throws Exception{
   //1. UUID瑜� �씠�슜�븳 怨좎쑀�븳 媛� �깮�꽦
    UUID uid = UUID.randomUUID();
    
    //2. UUID瑜� �씠�슜�븳 怨좎쑀�븳 媛�_�뙆�씪紐�
    String savedName = uid.toString() +"_"+originalName;
    
    //3. ���옣�맆 寃쎈줈瑜� 怨꾩궛(�뿰, �썡, �씪)
    String savedPath = calcPath(uploadPath);
    
    //4. 湲곕낯寃쎈줈+�뤃�뜑 寃쎈줈+�뙆�씪�씠由�
    File target = new File(uploadPath +savedPath,savedName);
    
    //5. �썝蹂명뙆�씪�쓣 ���옣�븯�뒗 遺�遺�
    FileCopyUtils.copy(fileData, target);
    
    //formatName: �썝蹂명뙆�씪�쓽 �솗�옣�옄瑜� �쓽誘명븳�떎. 
    //--> 6.�솗�옣�옄瑜� �씠�슜�빐 �씠誘몄� �뙆�씪�씤 寃쎌슦�� �븘�땶 寃쎌슦瑜� �굹�늻�뼱 泥섎━
    String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
    
    String uploadedFileName = null;
   
    //�씠誘몄� ���엯�쓽 �뙆�씪�씤 寃쎌슦�뿉�뒗 �뜽�꽕�씪�쓣 �깮�꽦�븯怨� 洹몃젃吏� �븡�� 寃쎌슦�뿉�뒗 makeIcon()�쓣 �넻�빐�꽌 留뚮벉
    //寃곌낵瑜� 留뚮뱾�뼱 �궡�뒗�뜲 makeIcon�� 寃쎈줈 泥섎━瑜� �븯�뒗 臾몄옄�뿴�쓽 移섑솚�슜�룄�씠�떎.
    if(MediaUtils.getMediaType(formatName) != null){
      uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
    }else{
      uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
    }
    
    return uploadedFileName;
    
  }
  
  private static  String makeIcon(String uploadPath, 
      String path, 
      String fileName)throws Exception{

    String iconName = 
        uploadPath + path + File.separator+ fileName;
    
    return iconName.substring(
        uploadPath.length()).replace(File.separatorChar, '/');
  }
  
  
  /**
   * uploadPath: 湲곕낯寃쎈줈
   * path: �뀈/�썡/�씪 �뤃�뜑
   * fileName: �쁽�옱 �뾽濡쒕뱶 �맂 �뙆�씪�쓽 �씠由�
   */
  //�뜽�꽕�씪 �씠誘몄�瑜� �깮�꽦�븯�뒗 硫붿냼�뱶( pom.xml�뿉 imageScalr �씪�씠釉뚯뼱由ш� 異붽��릺�뿀�뒗吏� �솗�씤)
  private static  String makeThumbnail(
              String uploadPath, 
              String path, 
              String fileName)throws Exception{
     //BufferedImage�뒗 �떎�젣 �씠誘몄�媛� �븘�땶 硫붾え由ъ긽�쓽 �씠誘몄�
     //�썝蹂명뙆�씪�쓣 硫붾え由ъ긽�쑝濡� 濡쒕뵫�븯怨� �겕湲곗뿉 留욊쾶 �옉�� �씠誘몄� �뙆�씪�뿉 �썝蹂� �뙆�씪�쓣 蹂듭궗
     BufferedImage sourceImg = 
        ImageIO.read(new File(uploadPath + path, fileName));
   
    //�뜽�꽕�씪�쓽 �씠誘몄� �궗�씠利덈�� �넂�씠 100�쑝濡� 留욎땄
//    BufferedImage destImg = 
//        Scalr.resize(sourceImg, 
//            Scalr.Method.AUTOMATIC, 
//            Scalr.Mode.FIT_TO_HEIGHT,200
////            Scalr.Mode.FIT_TO_WIDTH, 290
//            
//              );
    BufferedImage destImg = 
          Scalr.resize(sourceImg, 
                Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 290, 200
                );
    //���옣�릺�뒗 �뜽�꽕�씪 �씠誘몄��쓽 �뙆�씪�씠由꾩쓣 's_'濡� �떆�옉�븯�룄濡� �븿
    //'s_' 瑜� �젣�쇅�븯硫� �썝蹂명뙆�씪�쓽 �씠由꾩엫
    String thumbnailName = 
        uploadPath + 
        path + File.separator +"s_"+ fileName;
    
    File newFile = new File(thumbnailName);
    
    //
    String formatName = 
          fileName.substring(fileName.lastIndexOf(".")+1);
    
    
    ImageIO.write(destImg, formatName.toUpperCase(), newFile);
    return thumbnailName.substring(
        uploadPath.length()).replace(File.separatorChar, '/');
    //臾몄옄�뿴�쓣 移섑솚�븯�뒗 �씠�쑀 : 釉뚮씪�슦���뿉 �쐢�룄�슦�쓽 寃쎈줈濡� �궗�슜�븯�뒗 臾몄옄媛� �씤�떇�릺吏� �븡湲� �븣臾몄뿉 /濡� 移섑솚
  } 
  
  //�뤃�뜑 �깮�꽦�븯�뒗 湲곕뒫�씠 �븘�슂�븯湲� �븣臾몄뿉 湲곕낯�쟻�씤 寃쎈줈uploadPath瑜� �뙆�씪誘명꽣濡� �쟾�떖�쁽�옱 �떆�뒪�뀥�쓽 �궇吏쒖뿉 留욌뒗 �뀒�씠�꽣瑜� �뼸怨� 湲곕낯 寃쎈줈�� �븿猿�  makeDir()�쟾�떖�릺�뼱 �뤃�뜑 �깮�꽦 
  private static String calcPath(String uploadPath){
    
    Calendar cal = Calendar.getInstance();
    
    String yearPath = File.separator+cal.get(Calendar.YEAR);
    
    String monthPath = yearPath + 
        File.separator + 
        new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);

    String datePath = monthPath + 
        File.separator + 
        new DecimalFormat("00").format(cal.get(Calendar.DATE));
    
    makeDir(uploadPath, yearPath,monthPath,datePath);
    
    logger.info(datePath);
    
    return datePath;
  }
  
  
  private static void makeDir(String uploadPath, String... paths){
    
    if(new File(paths[paths.length-1]).exists()){
      return;
    }
    
    for (String path : paths) {
      
      File dirPath = new File(uploadPath + path);
      
      if(! dirPath.exists() ){
        dirPath.mkdir();
      } 
    }
  }
  
  
}