package com.example.appointmentservice.service;

import com.example.appointmentservice.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Gửi email xác nhận đặt lịch thành công.
     * FE sẽ chịu trách nhiệm gọi user-service để lấy email bệnh nhân
     * và truyền email đó xuống endpoint của appointment-service.
     */
    public void sendAppointmentConfirmationEmail(String toEmail, Appointment appointment) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Xác nhận đặt lịch khám thành công");

        StringBuilder body = new StringBuilder();
        body.append("Xin chào ").append(appointment.getPatientName()).append(",\n\n");
        body.append("Lịch khám của bạn đã được đặt thành công với thông tin như sau:\n");
        body.append("- Bệnh nhân: ").append(appointment.getPatientName()).append("\n");
        body.append("- Bác sĩ: ").append(appointment.getDoctorName()).append("\n");
        body.append("- Thời gian: ").append(appointment.getAppointmentDateTime()).append("\n");
        body.append("- Bệnh viện: ").append(appointment.getHospitalName()).append("\n");
        body.append("- Khoa: ").append(appointment.getDepartmentName()).append("\n\n");
        body.append("Vui lòng đến đúng giờ và mang theo giấy tờ cần thiết.\n\n");
        body.append("Trân trọng,\n");
        body.append("Smart Healthcare System");

        message.setText(body.toString());
        mailSender.send(message);
    }
}


