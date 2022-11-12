    /**
     * 날짜에 따른 업로트 파일 경로 생성 (연/월/일)
     * - 디텍토리가 존재하지 않는다면 새로 생성함
     * - ex) /2022/10/15/
     */
    public String getDateDirectory() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        // 운영체제에 독립적으로 사용하기 위해 File.seperator를 사용해야 한다
        String datePath =
                        File.separator
                        + sdf.format(date).replace("-", File.separator)
                        + File.separator;

        String fullPath = properties.getResourcesPath() + datePath; // 절대경로 뒤에 날짜 경로를 붙여 전체 경로 생성
        File file = new File(fullPath);
        if (!file.exists()) {
            log.info(">> 새 디렉토리를 생성했습니다: {}", Paths.get(fullPath).toUri());
            file.mkdirs(); // 디렉토리가 존재하지 않는다면 새로 생성
        }
        return datePath;
    }
