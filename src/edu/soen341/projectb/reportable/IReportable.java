package edu.soen341.projectb.reportable;

public interface IReportable {
    void record(_Error e);
    void getException();
	void printErrors();
    
}
