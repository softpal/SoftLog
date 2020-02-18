package com.softpal.softlog;

import android.util.Log;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public final class SoftLog
{
	
	/**
	 Priority constant for the println method; use SoftLog.v.
	 */
	public static final int VERBOSE = 2;
	
	/**
	 Priority constant for the println method; use Log.d.
	 */
	public static final int DEBUG = 3;
	
	/**
	 Priority constant for the println method; use Log.i.
	 */
	public static final int INFO = 4;
	
	/**
	 Priority constant for the println method; use Log.w.
	 */
	public static final int WARN = 5;
	
	/**
	 Priority constant for the println method; use Log.e.
	 */
	public static final int ERROR = 6;
	
	/**
	 Priority constant for the println method.
	 */
	public static final int ASSERT = 7;
	/**
	 *
	 */
	public static final int LOG_ID_MAIN = 0;
	/**
	 *
	 */
	public static final int LOG_ID_RADIO = 1;
	/**
	 *
	 */
	public static final int LOG_ID_EVENTS = 2;
	/**
	 *
	 */
	public static final int LOG_ID_SYSTEM = 3;
	/**
	 *
	 */
	public static final int LOG_ID_CRASH = 4;
	
	private SoftLog()
	{
	}
	
	/**
	 Send a {@link #VERBOSE} log message.  @param s
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 */
	public static void v(String tag,String msg)
	{
		//if( BuildConfig.DEBUG && Constants.showLogs == 1)
		if(BuildConfig.DEBUG && Constants.showLogs == 1)
		{
			Log.v(tag,msg);
		}
	}
	
	/**
	 Send a {@link #VERBOSE} log message and log the exception.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 @param tr  An exception to log
	 */
	public static void v(String tag,String msg,Throwable tr)
	{
		SoftLog.v(tag,msg,tr);
	}
	
	/**
	 Send a {@link #DEBUG} log message.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 */
	public static void d(String tag,String msg)
	{
		if( BuildConfig.DEBUG && Constants.showLogs == 1)
		{
			SoftLog.v(tag,msg);
		}
	}
	
	/**
	 Send a {@link #DEBUG} log message and log the exception.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 @param tr  An exception to log
	 */
	public static void d(String tag,String msg,Throwable tr)
	{
		SoftLog.v(tag,msg + '\n' + getStackTraceString(tr));
	}
	
	/**
	 Handy function to getInstance a loggable stack trace from a Throwable
	 
	 @param tr An exception to log
	 */
	public static String getStackTraceString(Throwable tr)
	{
		if(tr == null)
		{
			return "";
		}
		
		// This is to reduce the amount of log spew that apps do in the non-error
		// condition of the network being unavailable.
		Throwable t = tr;
		while(t != null)
		{
			if(t instanceof UnknownHostException)
			{
				return "";
			}
			t = t.getCause();
		}
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		tr.printStackTrace(pw);
		pw.flush();
		return sw.toString();
	}
	
	/**
	 Send an {@link #INFO} log message.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 */
	public static void i(String tag,String msg)
	{
		if( BuildConfig.DEBUG && Constants.showLogs == 1)
		{
			SoftLog.v(tag,msg);
		}
	}
	
	/**
	 Send a {@link #INFO} log message and log the exception.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 @param tr  An exception to log
	 */
	public static void i(String tag,String msg,Throwable tr)
	{
		SoftLog.v(tag,msg + '\n' + getStackTraceString(tr));
	}
	
	/**
	 Send a {@link #WARN} log message.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 */
	public static void w(String tag,String msg)
	{
		if( BuildConfig.DEBUG && Constants.showLogs == 1)
		{
			SoftLog.v(tag,msg);
		}
	}
	
	/**
	 Send a {@link #WARN} log message and log the exception.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 @param tr  An exception to log
	 */
	public static void w(String tag,String msg,Throwable tr)
	{
		SoftLog.v(tag,msg + '\n' + getStackTraceString(tr));
	}
	
	/*
	 * Send a {@link #WARN} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param tr An exception to log
	 */
	public static void w(String tag,Throwable tr)
	{
		SoftLog.v(tag,getStackTraceString(tr));
	}
	
	/**
	 Send an {@link #ERROR} log message.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 */
	public static void e(String tag,String msg)
	{
		
		if( BuildConfig.DEBUG && Constants.showLogs == 1)
		{
			SoftLog.v(tag,msg);
		}
	}
	
	/**
	 Send a {@link #ERROR} log message and log the exception.
	 
	 @param tag Used to identify the source of a log message.  It usually identifies the class or
	 activity where the log call occurs.
	 @param msg The message you would like logged.
	 @param tr  An exception to log
	 */
	public static void e(String tag,String msg,Throwable tr)
	{
		SoftLog.v(tag,msg + '\n' + getStackTraceString(tr));
	}
	
	/**
	 Low-level logging call.
	 
	 @param priority The priority/type of this log message
	 @param tag      Used to identify the source of a log message.  It usually identifies the class
	 or activity where the log call occurs.
	 @param msg      The message you would like logged.
	 
	 @return The number of bytes written.
	 */
	public static void println(int priority,String tag,String msg)
	{
		SoftLog.v(tag,msg);
	}
	
	/**
	 *
	 */
	@SuppressWarnings("unused")
	public static int println(int bufID,int priority,String tag,String msg)
	{
		return 0;
	}
}
