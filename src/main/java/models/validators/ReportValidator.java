package models.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.MessageConst;

public class ReportValidator {

    /**
     * 日報インスタンスの各項目についてバリデーションを行う
     * @param rv 日報インスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(ReportView rv) {
        List<String> errors = new ArrayList<String>();

        //タイトルのチェック
        String titleError = validateTitle(rv.getTitle());
        if (!titleError.equals("")) {
            errors.add(titleError);
        }

        //内容のチェック
        String contentError = validateContent(rv.getContent());
        if (!contentError.equals("")) {
            errors.add(contentError);
        }

        //勤怠チェック
        String attendanceError = validateAttendance(rv.getAttendanceAtwork(), rv.getLeavingWork());
        if (!attendanceError.equals("")) {
            errors.add(attendanceError);
        }

        String attendancedayError = validateAttendanceday(rv.getAttendanceAtwork().toLocalDate(),
                rv.getLeavingWork().toLocalDate(), rv.getReportDate());
        if (!attendancedayError.equals("")) {
            errors.add(attendancedayError);
        }

        return errors;

    }

    /**
     * タイトルに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param title タイトル
     * @return エラーメッセージ
     */
    private static String validateTitle(String title) {
        if (title == null || title.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     */
    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**追加
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param attendanceAtworkt 出勤　
     * @param　leavingWork　退勤
     * @return エラーメッセージ
     */

    private static String validateAttendance(LocalDateTime attendanceAtwork, LocalDateTime leavingWork) {
        if (attendanceAtwork == null || attendanceAtwork.equals("") || leavingWork == null || leavingWork.equals("")
                || attendanceAtwork.isAfter(leavingWork)) {
            return MessageConst.E_Attendance.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**追加
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param  出勤　
     * @param　leavingWork　退勤
     * @return エラーメッセージ
     */
    private static String validateAttendanceday(LocalDate attendanceAtwork, LocalDate leavingWork,
            LocalDate reportDate) {
        if (attendanceAtwork.isAfter(reportDate) || attendanceAtwork.isBefore(reportDate)
                || leavingWork.isBefore(reportDate) || leavingWork.isAfter(reportDate)) {
            return MessageConst.E_Attendanceday.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

}
