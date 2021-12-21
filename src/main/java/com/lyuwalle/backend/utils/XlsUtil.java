package com.lyuwalle.backend.utils;

import com.alibaba.druid.util.StringUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author lyuxiyang
 *
 * 导出excel的工具类
 */
public class XlsUtil {

    public static byte[] createXlsByte(List<String> headers, List<String> columnKeys, List<Map> rows) throws IOException{

        SXSSFWorkbook workbook = new SXSSFWorkbook();

        SXSSFSheet sheet = workbook.createSheet();
        //设置单元格格式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.FILL);

        //根据传进来的标题，设置标题行
        SXSSFRow header = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            SXSSFCell cell = header.createCell(i);
            cell.setCellStyle(cellStyle);
            String title = headers.get(i);
            if (StringUtils.isEmpty(title)) {
                throw new RuntimeException("header不可以为null, 可以设置为空串");
            }
            cell.setCellValue(title);
        }
        //设置正文
        for (int i = 0; i < rows.size(); i++) {
            SXSSFRow content = sheet.createRow(i + 1);
            Map map = rows.get(i);
            for (int j = 0; j < headers.size(); j++) {
                SXSSFCell cell = content.createCell(j);
                cell.setCellStyle(cellStyle);
                Object showedContent = map.get(columnKeys.get(j));
                if (Objects.isNull(showedContent)) {
                    continue;
                }
                cell.setCellValue(showedContent.toString());
            }
        }
        //写入文件
        byte[] bytes;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            workbook.write(byteArrayOutputStream);
            bytes = byteArrayOutputStream.toByteArray();
        }
        return bytes;

    }

    /**
     * 用于生成标题list
     *
     * @param objects
     * @return
     */
    public static List generateList(Object... objects) {
        List headers = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            headers.add(objects[i]);
        }
        return headers;
    }
    /**
     * 生成excel的内容映射
     *
     * @param objects
     * @return
     */
    public static Map hashMap(Object... objects) {
        Map result = new LinkedHashMap();
        for (int i = 0; i < objects.length / 2; i++) {
            result.put(objects[2 * i], objects[2 * i + 1]);
        }
        return result;
    }

}
