package com.alinesno.infra.base.storage.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 支持的文档类型
 */
@Getter
public enum DocumentTypeEnum {

    PPT("PPT", "支持PPT、PPTX等，兼容WPS、Office文档类型", "fa-solid fa-file-powerpoint", new FileTypeEnum[]{FileTypeEnum.PPT}),
    EXCEL("Excel", "支持Excel等，兼容WPS、Office文档类型", "fa-solid fa-file-excel", new FileTypeEnum[]{FileTypeEnum.XLS}),
    WORD("Word", "支持Doc、Docx等，兼容WPS、Office文档类型", "fa-solid fa-file-word", new FileTypeEnum[]{FileTypeEnum.DOC}),
    CVS("CVS", "支持CVS在线查看等，兼容WPS、Office文档类型", "fa-solid fa-file-csv", null), // 假设CSV没有直接对应
    PDF("PDF", "支持PDF在线查看等，兼容WPS、Office文档类型", "fa-solid fa-file-pdf", new FileTypeEnum[]{FileTypeEnum.PDF}),
    PNG("PNG", "支持 jpg, jpeg, png, gif, bmp, ico, jfif, webp 等图片预览（翻转，缩放，镜像）", "fa-solid fa-file-image", new FileTypeEnum[]{
            FileTypeEnum.PNG,
            FileTypeEnum.JPG,
            FileTypeEnum.JPEG,
            FileTypeEnum.GIF,
            FileTypeEnum.WEBP}),
    MP4("MP4", "支持 mp3, wav, mp4, flv 等音视频格式文件", "fa-solid fa-file-video", new FileTypeEnum[]{
            FileTypeEnum.MP4,
            FileTypeEnum.MOV,
            FileTypeEnum.AVI}), // 假设MP3不在这里，因为它是音频
    MP3("MP3", "支持 mp3, wav, mp4, flv 等音视频格式文件", "fa-solid fa-file-audio", new FileTypeEnum[]{
            FileTypeEnum.MP3,
            FileTypeEnum.WAV}),
    ZIP("ZIP", "支持 zip, rar, jar, tar, gzip, 7z 等压缩包", "fa-solid fa-file-archive", new FileTypeEnum[]{FileTypeEnum.ZIP, FileTypeEnum.RAR}) ;

    // XMIND("XMind", "支持 xmind 软件模型文件", "fa-solid fa-brain", new FileTypeEnum[]{new FileTypeEnum("XMind 文件", "xmind", "xmind.png")}); // 假设XMind没有被定义


    private final String name;
    private final String desc;
    private final String icon;
    private final FileTypeEnum[] fileTypes;

    DocumentTypeEnum(String name, String desc, String icon, FileTypeEnum[] fileTypes) {
        this.name = name;
        this.desc = desc;
        this.icon = icon;
        this.fileTypes = fileTypes;
    }

    // 获取到每个DocumentType类型的fileType返回String格式
    public String getFileTypeStr() {
        if (fileTypes != null && fileTypes.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (FileTypeEnum fileType : fileTypes) {
                sb.append(fileType.getName()).append(",");
            }
            return sb.toString().substring(0, sb.length() - 1);
        }
        return "";
    }

    // 通过name获取到icon
    public static String getIconByName(String name) {
        for (DocumentTypeEnum type : DocumentTypeEnum.values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type.getIcon();
            }
        }
        return null;
    }

    public static List<DocumentTypeEnum> getAllDocumentTypes() {
        return Arrays.asList(DocumentTypeEnum.values());
    }

    public static Object[] getAllNames() {
        DocumentTypeEnum[] documentTypes = DocumentTypeEnum.values();
        Object[] names = new Object[documentTypes.length];
        for (int i = 0; i < documentTypes.length; i++) {
            names[i] = documentTypes[i].getName();
        }
        return names;
    }

    public static String getAllNameStr() {

        StringBuilder names = new StringBuilder();

        for(DocumentTypeEnum d : getAllDocumentTypes()){
            names.append(",")
                 .append(d.getName());
        }

        return names.toString();
    }
}
