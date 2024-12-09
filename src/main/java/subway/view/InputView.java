package subway.view;

import java.io.BufferedReader;
import java.io.IOException;

public class InputView {

    private BufferedReader br;

    public String mainInput() throws IOException {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");

        return br.readLine();
    }

    public String stationManagementInput() throws IOException {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");

        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
        return br.readLine();
    }

    public String stationRegisterInput() throws IOException {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return br.readLine();
    }

    public String stationDeleteInput() throws IOException {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return br.readLine();
    }

    public String lineManagementInput() throws IOException {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");

        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");

        return br.readLine();
    }

    public String lineRegisterInput() throws IOException {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return br.readLine();
    }

    public String lineUpBoundTerminalInput() throws IOException {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return br.readLine();
    }

    public String lineDownBoundTerminalInput() throws IOException {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return br.readLine();
    }


    public String lineDeleteInput() throws IOException {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return br.readLine();
    }

    public String sectionInput() throws IOException {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");

        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");

        return br.readLine();

    }

    public String deleteSectionOfLine() throws IOException {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        return br.readLine();
    }

    public String deleteSectionOfStation() throws IOException {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        return br.readLine();
    }

    public String registerSectionOfLine() throws IOException {
        System.out.println("## 등록할 구간의 노선을 입력하세요.");
        return br.readLine();
    }

    public String registerSectionOfStation() throws IOException {
        System.out.println("## 등록할 구간의 역을 입력하세요.");
        return br.readLine();
    }

}
