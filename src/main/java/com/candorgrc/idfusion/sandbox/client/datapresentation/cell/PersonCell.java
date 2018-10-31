package com.candorgrc.idfusion.sandbox.client.datapresentation.cell;

import com.candorgrc.idfusion.sandbox.client.model.PersonJSO;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.client.SafeHtmlTemplates.Template;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class PersonCell extends AbstractCell<PersonJSO> {

	public static enum Action {
		CREATE, UPDATE, COPY, DELETE
	}

	/*
	 * Safe XHTML5 Template instance.
	 */
	private Template template;

	/*
	 * Constructor method
	 */
	public PersonCell() {
		/*
		 * register for consuming click events
		 */
		super(BrowserEvents.CLICK);

		// instantiate Safe HTML Template
		if (template == null) {
			template = GWT.create(Template.class);
		}
	}

	/*
	 * HTML render method.
	 *
	 * (non-Javadoc)
	 *
	 * @see
	 * com.google.gwt.cell.client.AbstractCell#render(com.google.gwt.cell.client
	 * .Cell.Context, java.lang.Object,
	 * com.google.gwt.safehtml.shared.SafeHtmlBuilder)
	 */
	@Override
	public void render(Context context, PersonJSO value, SafeHtmlBuilder sb) {
		if (value != null) {

			// build
			//@formatter:off
			sb.append(template.build(value.getTitle(), 			// 0
								     value.getFirstName(), 		// 1
								     value.getLastName(),  		// 2
								     value.getSuffix(), 		// 3
								     value.getGender(), 		// 4
								     value.getRace(), 			// 5
								     value.getLanguage(), 		// 6
								     value.getUniversity(),		// 7
								     value.getBuzzword(),  		// 8
								     value.getEmail(),  		// 9
								     value.getJobTitle(), 		// 10
								     value.getLinkedinSkill(), 	// 11
								     value.getAvatar(), 		// 12
								     value.getCompany(), 		// 13
								     value.getDepartment(), 	// 14
								     value.getEin(), 			// 15
								     Action.UPDATE.name(), 		// 16
								     Action.COPY.name(), 		// 17
								     Action.DELETE.name())); 	// 18
			//@formatter:on

			// other asynchronous workers may be added here
		}
	}

	/*
	 * Handle Browser Event(s).
	 *
	 * (non-Javadoc)
	 *
	 * @see
	 * com.google.gwt.cell.client.AbstractCell#onBrowserEvent(com.google.gwt.
	 * cell.client.Cell.Context, com.google.gwt.dom.client.Element,
	 * java.lang.Object, com.google.gwt.dom.client.NativeEvent,
	 * com.google.gwt.cell.client.ValueUpdater)
	 */
	@Override
	public void onBrowserEvent(Context context, Element parent, PersonJSO value, NativeEvent event, ValueUpdater<PersonJSO> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);
		final Element element = event.getEventTarget().cast();
		final String action = element.getAttribute("action");

		if (!action.isEmpty()) {
			value.setAction(action);
			valueUpdater.update(value);
		}
	}

	/**
	 * Cell XHTML Template.
	 * 
	 * @designer: feel free to modify it in order to meet your expectations
	 *
	 */
	public interface Template extends SafeHtmlTemplates {
		//@formatter:off
		@Template("<div class='person-cell {4}'>"
					 + "<header>"
						+ "<div class='floating-button floating-dial-bottom-left'>"
							+ "<button class='float-trigger float-btn'><i class='fa fa-cog'></i></button>"
							+ "<ul class='share-items'>"
								+" <li class='floating-item item-delete'>"
									+ "<button class='delete float-btn' action='{18}' title='Delete'><i class='delete fa fa-trash' action='{18}'></i></button>"
								+"</li>"
								+ "<li class='floating-item item-copy'>"
									+ "<button class='copy float-btn' action='{17}' title='Copy'><i class='copy fa fa-clone' action='{17}'></i></button>"
								+ "</li>"
								+ " <li class='floating-item item-edit'>"
									+ "<button class='edit float-btn' action='{16}' title='Edit'><i class='edit fa fa-pencil' action='{16}'></i></button>"
								+ "</li>"
							+ "</ul>"
						+ "</div>"
				 		+ "<figure title='Name'>"
						 	+ "<div class='image'>"
				 				+ "<img class='avatar' src=\"{12}\"></img>"
								+ "<i class='{4} gender-icon' title='{4}'></i>"
							+ "</div>"
				 			+ "<figcaption class='caption'>"
				 				+ "<span class='title' title='Title'>{0} </span>"
				 				+ "<span class='first-name' title='First Name'>{1} </span>"
				 				+ "<span class='last-name' title='Last Name'>{2}, </span>"
								 + "<span class='suffix' title='Suffix'>{3}</span>"
								 + "<p>"
									+ "<span class='job-title' title='Job Title'>{10}</span>"
									+ "<span > @ </span>"
									+ "<span class='company' title='Company'>{13}</span>"
								+ "</p>"
							 + "</figcaption>"
						 + "</figure>"
					+ "</header>"
					+ "<section class='tabs'>"
						+ "<ul class='tabs-list'>"
							+ "<li class='tabs-item active' data-target='info'>"
								+ "<span>Info</span>"
							+ "</li>"
							+ "<li class='tabs-item' data-target='education'>"
								+ "<span>Education</span>"
							+ "</li>"
							+ "<li class='tabs-item' data-target='work'>"
								+ "<span>Work</span>"
							+ "</li>"
							+ "<li class='tabs-item' data-target='social'>"
								+ "<span>Social</span>"
							+ "</li>"
						+"</ul>"
						+ "<div class='tabs-container'>"
							+ "<div class='personal-info  tabs-content active' data-target='info'>"
								+"<h3 class='tabs-title'>Personal information</h3>"
								+ "<div class='race' title='Race'>{5}</div>"
								+ "<div class='language' title='Language'>{6}</div>"
							+ "</div>"
							+ "<div class='education tabs-content' data-target='education'>"
								+"<h3 class='tabs-title'>Education</h3>"
								+ "<div class='university' title='University'>{7}</div>"
							+ "</div>"
							+ "<div class='work tabs-content' data-target='work'>"
								+"<h3 class='tabs-title'>Work</h3>"
								+ "<div class='department' title='Department'>{14}</div>"
								+ "<div class='ein' title='Employer Identification Number'>{15}</div>"
								+ "<div class='email' title='E-Mail'>{9}</div>"
							+ "</div>"
							+ "<div class='social tabs-content' data-target='social'>"
								+ "<div class='linkedin-skill' title='LinkedIn Skill'>{11}</div>"
								+ "<div class='buzzword' title='Buzzword'>{8}</div>"
							+ "</div>"
						+ "</div>"
					+ "</section>"
				+ "</div>")
		//@formatter:on
		SafeHtml build(String title, String firstName, String lastName, String suffix, String gender, String race, String language, String university, String buzzword,
				String email, String jobTitle, String linkedinSkill, String avatar, String company, String department, String ein, String editAction, String copyAction,
				String deleteAction);
	}

}
